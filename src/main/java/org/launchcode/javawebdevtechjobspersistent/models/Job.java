package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.*;

@Entity
public class Job extends AbstractEntity{

    private String skill;

    @ManyToOne
    private Employer employer;

    public Job() { }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public String getSkills(){ return skill;}

    public void setSkills(String skill) { this.skill = skill; }
}
