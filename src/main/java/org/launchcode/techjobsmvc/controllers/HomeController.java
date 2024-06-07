package org.launchcode.techjobsmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController extends TechJobsController {
    @GetMapping(value = "/")
    public String index() {
        return "index";
    }
}