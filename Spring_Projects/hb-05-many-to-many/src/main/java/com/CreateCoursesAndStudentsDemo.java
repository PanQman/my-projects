package com;

import com.HibernateEntity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCoursesAndStudentsDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            Course course = new Course("Java");
            Course course2 = new Course("SQL");

            Student student = new Student("Adam", "Paz", "test@tst.pl");
            Student student2 = new Student("Emil", "Wilczynski", "akmf@aks.pl");
            Student student3 = new Student("Robert", "Trudny", "ok@ko.com");

            course.addStudent(student);
            course.addStudent(student2);
            course.addStudent(student3);

            session.save(student);
            session.save(student2);
            session.save(student3);

            session.save(course);
            session.save(course2);
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
