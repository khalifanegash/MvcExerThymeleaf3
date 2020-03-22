package se.ecutb.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Fever {
    @GetMapping("/temperature")
    public String temp(@RequestParam(value = "temperature", required = false, defaultValue = "0.0") double temperature, Model model){
      String message = null;
        if (temperature >= 33 && temperature <= 36.1){
            message = "It's Normal";
        }else if (temperature >= 36.1 && temperature <= 37.1){
          message = "Normal";
      }else if (temperature > 37.1 && temperature <= 40.1){
          message = "Have fever";

      }else if (temperature > 40.1){
          message = "Hyperthemia";
      }else if(temperature != 0 && temperature <33){
            message = "you may be died";
        }
      model.addAttribute("temperature", message);
      return "fever";
    }
    @PostMapping("temperature/")
    public String process(@RequestParam(value = "temperature", defaultValue = "0.0") double temp, Model model){
        model.addAttribute("temperature", temp);
       return "redirect:/temperature";
    }
}
