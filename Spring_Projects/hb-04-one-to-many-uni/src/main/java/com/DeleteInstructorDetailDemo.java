package com;

import com.HibernateEntity.Instructor;
import com.HibernateEntity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteInstructorDetailDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            int id = 4;
            session.beginTransaction();
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
            System.out.println("the associated instructor " + instructorDetail.getInstructor());

            instructorDetail.getInstructor().setInstructorDetail(null); //delete reference between tables
            session.delete(instructorDetail);

            session.getTransaction().commit();
            System.out.println("Done!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
