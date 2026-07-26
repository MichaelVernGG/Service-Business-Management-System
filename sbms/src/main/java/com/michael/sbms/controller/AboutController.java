package com.michael.sbms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.michael.sbms.service.AboutService;


@Controller
@RequestMapping("/about")
public class AboutController {
	
	@Autowired
	private AboutService aboutService;
	
	
    @GetMapping
    public String aboutInfo(Model model) {
        return "about";
    }
}
