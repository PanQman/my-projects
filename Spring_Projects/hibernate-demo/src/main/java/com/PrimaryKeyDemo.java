package com;

import com.hibernateDemo.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Student student1 = new Student("Ewa", "Robin", "ifkf@wp.pl");
            Student student2 = new Student("Maciek", "Kowalski", "qefwq@fsd.pl");
            Student student3 = new Student("Gabriel", "Trudny", "vadv@sd.pl");
            // start a transaction
            session.beginTransaction();
            // save the student object
            session.save(student1);
            session.save(student2);
            session.save(student3);
            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
