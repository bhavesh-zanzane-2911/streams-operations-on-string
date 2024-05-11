package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamFilterApiPractice {

    public static void main(String[] args) {
        List<Person> personsList = PersonService.getPersonsList();
        //filter out companies for which Bhavesh has worked
        Person bhavesh = personsList.stream().
                filter(person -> person.getName().equals("Bhavesh"))
                .findFirst()
                .get();
        System.out.println(bhavesh);

        Integer bhaveshAdharNo = personsList.stream()
                .filter(person -> person.getName().equals("Bhavesh"))
                .map(Person::getAdharNo)
                .findFirst()
                .get();


        System.out.println(bhaveshAdharNo);

        Set<String> companiesForWhichBhaveshWorked = personsList.stream().filter(person -> person.getName().equals("Bhavesh"))
                .flatMap(person -> person.getTotalExperience().stream())
                .map(EmployeeExperience::getCompanyName)
                .collect(Collectors.toSet());
        System.out.println(companiesForWhichBhaveshWorked);

        //langues he known

        Set<String> languagesKnown=personsList.stream().filter(person -> person.getName().equals("Bhavesh"))
                .flatMap(person -> person.getTotalExperience().stream())
                .flatMap(employeeExperience -> employeeExperience.getLanguagesKnown().stream())
                .collect(Collectors.toSet());
        System.out.println(languagesKnown);

        List<String> sortedPersonsInReversedOrder=personsList.stream().sorted(Comparator.comparing(Person::getName).reversed())
                .map(Person::getName).toList();
        System.out.println(sortedPersonsInReversedOrder);
    }
}
