package org.launchcode.techjobsmvc.controllers;

import org.launchcode.techjobsmvc.models.Job;
import org.launchcode.techjobsmvc.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("search")
public class SearchController extends TechJobsController {

    @GetMapping(value = "")
    public String search(Model model) {
        model.addAttribute("selectedType", "all");
        return "search";
    }

    //TODO #3: creates handler method to process search request & render updated search view
    @PostMapping("results") // must match form action
    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {
        ArrayList<Job> jobs;
        if (searchType.equals("all")) {
            model.addAttribute("title", "Jobs With All: "+searchTerm);
        }
        else {
            model.addAttribute(
                    "title",
                    "Jobs With "+searchType+": "+searchTerm
            );
        }
        jobs = JobData.findByColumnAndValue(searchType, searchTerm);
        model.addAttribute("selectedType", searchType);
        model.addAttribute("selectedKeyword", searchTerm);
        model.addAttribute("jobs", jobs);
        return "search";
    }
}