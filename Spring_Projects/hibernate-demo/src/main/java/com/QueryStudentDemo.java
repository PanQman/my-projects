package com;

import com.hibernateDemo.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class QueryStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            //List studentList = session.createQuery("from Student").getResultList(); //Java Class Name
            //List studentList = session.createQuery("from Student s where s.lastName = 'Trudny'").getResultList(); //Java atribute Name
            List studentList = session.createQuery("from Student s where s.lastName = 'Trudny' OR " +
                    "s.email LIKE '%fsd%'").getResultList(); //Java atribute Name

            for (Object s : studentList) {
                System.out.println(s);
            }

            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
