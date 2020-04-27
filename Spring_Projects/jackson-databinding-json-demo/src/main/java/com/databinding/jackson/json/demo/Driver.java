package com.databinding.jackson.json.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Driver {

    public static void main(String[] args) {

        try {
            ObjectMapper mapper = new ObjectMapper();
            Student student = mapper.readValue(new File("data/sample-full.json"), Student.class);

            System.out.println("First Name = " + student.getFirstName());
            System.out.println("Last Name = " + student.getLastName());

            Address address = student.getAddress();
            System.out.println("Street = " + address.getStreet());
            System.out.println("City = " + address.getCity());

            for (String s : student.getLanguages()){
                System.out.println(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
