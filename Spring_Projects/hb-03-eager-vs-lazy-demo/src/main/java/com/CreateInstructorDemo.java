package com;

import com.HibernateEntity.Course;
import com.HibernateEntity.Instructor;
import com.HibernateEntity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateInstructorDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            Instructor instructor = new Instructor("Chad", "Roby", "robin@sinds.com");
            InstructorDetail instructorDetail = new InstructorDetail("www.youtube.com/ChadRoby", "Science");
            instructor.setInstructorDetail(instructorDetail); //associate the objects
            session.save(instructor);
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
