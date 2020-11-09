package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Skill extends AbstractEntity {

    @NotNull
    @Size(min=1, max=250)
    private String description;

    @ManyToMany(mappedBy = "skills")
    private Job jobs;

    public Skill() { }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description;  }
}