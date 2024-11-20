package com.lecture13.SSF_lecture_13.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lecture13.SSF_lecture_13.model.Person;
import com.lecture13.SSF_lecture_13.service.PersonService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    PersonService personService;

    @GetMapping("")
    public String personListing(Model model){
        List<Person> persons =personService.findAll();
        model.addAttribute("persons", persons);
        return "personList";
    }
    @GetMapping("/create")
    public String createForm(Model model) {
        Person p = new Person();
        model.addAttribute("person", p);
        return "personCreate";
        //TODO thymeleaf formatted date
    }
    
}
