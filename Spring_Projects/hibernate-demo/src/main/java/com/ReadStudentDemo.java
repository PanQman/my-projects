package com;

import com.hibernateDemo.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ReadStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Student student = new Student("Dan", "Rog", "dsao@sd.pl");
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();

            System.out.println("Saved student. Generated id: " + student.getId());

            session = factory.getCurrentSession();
            session.beginTransaction();

            Student mystudent = session.get(Student.class, student.getId());
            System.out.println(mystudent);

            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
