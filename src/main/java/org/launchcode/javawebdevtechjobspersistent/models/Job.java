package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.*;

@Entity
public class Job extends AbstractEntity{

    private String skills;

    @ManyToOne
    private Employer employer;

    public Job() { }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public String getSkills(){ return skills;}

    public void setSkills(String skill) { this.skills = skill; }
}