package se.ecutb.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Home {

    private List<String> strings = new ArrayList<>();


    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @PostMapping("/contact")
    public String contact(@RequestParam(value = "contact", required = false) String string){
        strings.add(string);
        return "redirect:/contact-list";
    }
    @GetMapping("/contact-list")
    public String contactList(@RequestParam( value = "contact" ,required = false)Model model){
        model.addAttribute("contacts", strings);
        return "contact-list";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }
}
