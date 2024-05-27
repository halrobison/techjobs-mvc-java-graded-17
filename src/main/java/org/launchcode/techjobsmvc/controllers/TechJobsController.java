package org.launchcode.techjobsmvc.controllers;

import org.springframework.web.bind.annotation.ModelAttribute;
import java.util.HashMap;

// super bonus task
public class TechJobsController {
    private static HashMap<String, String> actionChoices = new HashMap<>();
    private static HashMap<String, String> columnChoices = new HashMap<>();

    public TechJobsController() {
//  change once here to update nav bar & search options everywhere
//	re-usable modular code
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
        //  super bonus:
        //    method does same functionality as
        //    model.addAttribute("actions", actionChoices);
        //    that was originally in HomeController
        //    now each controller extends this functionality
        //    without writing model.addAttribute("actions", actionChoices);
        //    however, this was never in any controller
        //    because fragments.html nav links path & text value were hard coded
        return actionChoices;
    }

    @ModelAttribute("columns") // sets actions variable to HashMap actionChoices
    public static HashMap getColumnChoices() {
        //  super bonus: same logic as getActionChoices()
        //    not understood why this getter method needs to be public
        //      in order to share functionality with child
        return columnChoices;
    }
    // TODO: bind actions in JobField model & fragments.html <element name="actions">
}
