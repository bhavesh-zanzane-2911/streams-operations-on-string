package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonService {

    public static List<Person> getPersonsList(){
        Person p1=new Person(1, "Bhavesh",getEmployeeExperience());
        Person p2=new Person(2, "Adesh",getEmployeeExperience1());
        Person p3=new Person(3, "Yogita",getEmployeeExperience2());
        return Arrays.asList(p1,p2,p3);
    }

    public  static List<EmployeeExperience> getEmployeeExperience(){
        List<EmployeeExperience> employeeExperiences=new ArrayList<>();
        employeeExperiences.add(new EmployeeExperience(101, "Amdocs", 2,Arrays.asList("Java", "Python")));
        employeeExperiences.add(new EmployeeExperience(102, "MediaOcean", 3,Arrays.asList("Java", "CPP")));
        employeeExperiences.add(new EmployeeExperience(103, "Citi", 4,Arrays.asList("Java", "Go")));
   return employeeExperiences;
    }

    public  static List<EmployeeExperience> getEmployeeExperience1(){
        List<EmployeeExperience> employeeExperiences=new ArrayList<>();
        employeeExperiences.add(new EmployeeExperience(201, "Impetus", 2,Arrays.asList("Java", "C")));
        employeeExperiences.add(new EmployeeExperience(202, "Amdocs", 3,Arrays.asList("Java", "CPP")));
        employeeExperiences.add(new EmployeeExperience(203, "Morgan", 4,Arrays.asList("Java", "Go")));
        return employeeExperiences;
    }

    public  static List<EmployeeExperience> getEmployeeExperience2(){
        List<EmployeeExperience> employeeExperiences=new ArrayList<>();
        employeeExperiences.add(new EmployeeExperience(301, "HSBC", 2,Arrays.asList("Java", "React")));
        employeeExperiences.add(new EmployeeExperience(302, "Amdocs", 3,Arrays.asList("Java", "CPP")));
        employeeExperiences.add(new EmployeeExperience(303, "HCL", 4,Arrays.asList("Java", "C")));
        return employeeExperiences;
    }

}
