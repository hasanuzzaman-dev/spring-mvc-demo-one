package com.hasan.demo.controller;

import com.hasan.demo.model.Alien;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    //ModelAttribute at Method level
    @ModelAttribute
    public void modelData(Model model){
        model.addAttribute("name", "Aliens");
    }

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("add")
    public String add(@RequestParam("num1") int i, @RequestParam("num2") int j, Model model) {

        int result = i + j;
        model.addAttribute("result", result);

        return "result";
    }

    // RequestParam with Model
    /*
    @RequestMapping("addAlien")
    public String addAlien(@RequestParam("aid") int aid, @RequestParam("name") String name, Model model){

        Alien alien = new Alien();
        alien.setAid(aid);
        alien.setName(name);

        model.addAttribute("alien",alien);

        return "result";
    }*/

    // Use of ModelAttribute with Model
    /*@RequestMapping("addAlien")
    public String addAlien(@ModelAttribute Alien alien, Model model){

        model.addAttribute("alien",alien);

        return "result";
    }*/

    // Use of ModelAttribute without Model
    /*@RequestMapping("addAlien")
    public String addAlien(@ModelAttribute("a1") Alien a){
        return "result";
    }*/

    ////////////// GET or POST Method   ///////////////

    //Get Method using RequestMapping
    /*@RequestMapping(value = "addAlien", method = RequestMethod.GET)
    public String addAlien(@ModelAttribute("alien") Alien alien){
        return "result";
    }*/

    //POST Method using RequestMapping
    /*@RequestMapping(value = "addAlien", method = RequestMethod.POST)
    public String addAlien(@ModelAttribute("alien") Alien alien){
        return "result";
    }*/

    //PostMapping
    @PostMapping(value = "addAlien")
    public String addAlien(@ModelAttribute("alien") Alien alien){
        return "result";
    }
    @GetMapping("getAliens")
    public String getAliens(Model model){
        List<Alien> aliens = Arrays.asList(
                new Alien(101,"Hasan"),
                new Alien(102, "Shakil"),
                new Alien(103, "Jashim")
        );

        model.addAttribute("result",aliens);

        return "showAliens";
    }
}
