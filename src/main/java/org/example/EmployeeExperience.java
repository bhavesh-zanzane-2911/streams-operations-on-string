package org.example;


import java.util.List;
import java.util.Objects;

public class EmployeeExperience {

    private Integer employeeId;
    private String companyName;
    private Integer experience;

    private List<String> languagesKnown;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public EmployeeExperience(Integer employeeId, String companyName, Integer experience, List<String> languagesKnown) {
        this.employeeId = employeeId;
        this.companyName = companyName;
        this.experience = experience;
        this.languagesKnown = languagesKnown;
    }

    public EmployeeExperience() {
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public List<String> getLanguagesKnown() {
        return languagesKnown;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeExperience that = (EmployeeExperience) o;
        return Objects.equals(employeeId, that.employeeId) && Objects.equals(companyName, that.companyName) && Objects.equals(experience, that.experience) && Objects.equals(languagesKnown, that.languagesKnown);
    }

    @Override
    public String toString() {
        return "EmployeeExperience{" +
                "employeeId=" + employeeId +
                ", companyName='" + companyName + '\'' +
                ", experience=" + experience +
                ", languagesKnown=" + languagesKnown +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, companyName, experience, languagesKnown);
    }

    public void setLanguagesKnown(List<String> languagesKnown) {
        this.languagesKnown = languagesKnown;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }



}
