package com;

import com.HibernateEntity.Course;
import com.HibernateEntity.Instructor;
import com.HibernateEntity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class FetchJoinDemo {

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
            int id = 1;

            Query<Instructor> query = session.createQuery(
                            "select i from instructor i " +
                            "JOIN fetch i.courseList " +
                            "where i.id =: idInstructor",
                    Instructor.class);

            query.setParameter("idInstructor", id);

            Instructor instructor = query.getSingleResult();

            System.out.println(instructor);
            session.getTransaction().commit();
            session.close();

            System.out.println("\nsession is close \n");
            System.out.println("Courses: " + instructor.getCourseList());

        } finally {

            factory.close();
        }
    }
}
