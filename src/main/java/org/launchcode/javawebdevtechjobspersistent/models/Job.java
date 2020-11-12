package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Job extends AbstractEntity{

    @ManyToMany
    private List<Skill> skills = new ArrayList<>();

    @ManyToOne
    private Employer employer;

    public Job() { }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public List<Skill> getSkills(){ return skills;}

    public void setSkills(List<Skill> skill) { this.skills = skill; }

}