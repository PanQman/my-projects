package com;

import com.hibernateDemo.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class UpdateStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            int studentId = 2;
            session.beginTransaction();

            Student myStudent = session.get(Student.class, studentId);
            myStudent.setFirstName("Scooby");
            myStudent.setLastName("Doo");
            session.getTransaction().commit();


            session = factory.getCurrentSession();
            session.beginTransaction();

            session.createQuery("update Student set email='foobar@aviva.pl' where email like '%fkf%'")
            .executeUpdate(); // executeUpdate() used for update and delete

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
