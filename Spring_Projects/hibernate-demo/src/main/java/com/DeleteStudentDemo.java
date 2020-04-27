package com;

import com.hibernateDemo.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
/*            int studentId = 8;
            Student myStudent = session.get(Student.class, studentId);
            session.delete(myStudent);
            session.getTransaction().commit();*/

            session.createQuery("delete from Student where id=8").executeUpdate();
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
