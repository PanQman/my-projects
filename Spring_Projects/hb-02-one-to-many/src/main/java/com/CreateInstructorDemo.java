package com;

import com.HibernateEntity.Instructor;
import com.HibernateEntity.InstructorDetail;
import com.HibernateEntity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
/*            Instructor instructor = new Instructor("Chad", "Roby", "robin@sinds.com");
            InstructorDetail instructorDetail = new InstructorDetail("www.youtube.com/ChadRoby", "Science");
            instructor.setInstructorDetail(instructorDetail); //associate the objects

            session.beginTransaction();

            //save the instructor
            //this will ALSO save the details object
            session.save(instructor);
            //because of CascadeType.ALL*/

            Instructor instructor = new Instructor("Mark", "Powen", "max@potion.com");
            InstructorDetail instructorDetail = new InstructorDetail("www.youtube.com/MarkPowen", "Math");
            instructor.setInstructorDetail(instructorDetail); //associate the objects

            session.beginTransaction();
            session.save(instructor);
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
