package org.launchcode.techjobsmvc.controllers;

import org.springframework.web.bind.annotation.ModelAttribute;
import java.util.HashMap;

// super bonus task
public class TechJobsController {
    private static HashMap<String, String> actionChoices = new HashMap<>();
    private static HashMap<String, String> columnChoices = new HashMap<>();

    public TechJobsController() {
        actionChoices.put("search", "Search");
        actionChoices.put("list", "List");

        columnChoices.put("all", "All");
        columnChoices.put("employer", "Employer");
        columnChoices.put("location", "Location");
        columnChoices.put("positionType", "Position Type");
        columnChoices.put("coreCompetency", "Skill");
    }

    // spring boot @ModelAttribute() annotation binds actions variable to HashMap actionChoices
    @ModelAttribute("actions")
    private static HashMap getActionChoices() {
        return actionChoices;
    }

    @ModelAttribute("columns")
    public static HashMap getColumnChoices() {
        return columnChoices;
    }
    // TODO: bind actions in JobField model & fragments.html <element name="actions">
}
