package org.launchcode.javawebdevtechjobspersistent.controllers;

import org.launchcode.javawebdevtechjobspersistent.models.Employer;
import org.launchcode.javawebdevtechjobspersistent.models.Job;
import org.launchcode.javawebdevtechjobspersistent.models.JobData;
import org.launchcode.javawebdevtechjobspersistent.models.Skill;
import org.launchcode.javawebdevtechjobspersistent.models.data.EmployerRepository;
import org.launchcode.javawebdevtechjobspersistent.models.data.JobRepository;
import org.launchcode.javawebdevtechjobspersistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import static org.launchcode.javawebdevtechjobspersistent.controllers.ListController.columnChoices;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private SkillRepository skillRepository;

    @RequestMapping("")
    public String search(Model model) {

        Iterable<Job> jobs = jobRepository.findAll();
        Iterable<Skill> skills = skillRepository.findAll();
        Iterable<Employer> employers = employerRepository.findAll();

        model.addAttribute("columns", columnChoices);
        model.addAttribute("jobs", jobs);
        model.addAttribute("skills", skills);
        model.addAttribute("employers", employers);

        return "search";
    }

    @PostMapping("results")
    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm){
        Iterable<Job> jobs;
        if (searchTerm.toLowerCase().equals("all") || searchTerm.equals("")){
            jobs = jobRepository.findAll();
        } else {
            jobs = JobData.findByColumnAndValue(searchType, searchTerm, jobRepository.findAll());
        }
        model.addAttribute("columns", columnChoices);
        model.addAttribute("title", "Jobs with " + columnChoices.get(searchType) + ": " + searchTerm);
        model.addAttribute("jobs", jobs);

        return "search";
    }
}