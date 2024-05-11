package org.example;

import java.util.List;
import java.util.Objects;

public class Person {

    private Integer adharNo;
    private String name;
    private List<EmployeeExperience> totalExperience;

    public Person(Integer adharNo, String name, List<EmployeeExperience> totalExperience) {
        this.adharNo = adharNo;
        this.name = name;
        this.totalExperience = totalExperience;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "adharNo=" + adharNo +
                ", name='" + name + '\'' +
                ", totalExperience=" + totalExperience +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(adharNo, person.adharNo) && Objects.equals(name, person.name) && Objects.equals(totalExperience, person.totalExperience);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adharNo, name, totalExperience);
    }

    public Integer getAdharNo() {
        return adharNo;
    }

    public void setAdharNo(Integer adharNo) {
        this.adharNo = adharNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EmployeeExperience> getTotalExperience() {
        return totalExperience;
    }

    public void setTotalExperience(List<EmployeeExperience> totalExperience) {
        this.totalExperience = totalExperience;
    }


}
