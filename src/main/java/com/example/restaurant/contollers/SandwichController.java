package com.example.restaurant.contollers;

import com.example.restaurant.domain.Ingredient;
import com.example.restaurant.domain.Sandwich;
import com.example.restaurant.domain.Order;
import com.example.restaurant.service.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SandwichController {
    @Autowired
    private ApplicationContext applicationContext;

    private OrderService orderService;
    //private static Sandwich sandwich1;
    //private Sandwich sandwich;




/*
    @GetMapping("/AddSandwich")
    public String addSandwich(Model theModel){
        Sandwich newSandwich = new Sandwich();
        //sandwich1 = sandwich;
        theModel.addAttribute("sandwich", newSandwich);

        List<String> breads = new ArrayList<>();
        breads.add("whole wheat");
        breads.add("sourdough");
        breads.add("white");
        breads.add("wrap");
        breads.add("brioche roll");
        theModel.addAttribute("breads", breads);
        List<String> proteins = new ArrayList<>();
        proteins.add("chicken");
        proteins.add("beef");
        proteins.add("turkey");
        proteins.add("shrimp");
        proteins.add("tofu");
        theModel.addAttribute("proteins", proteins);
        List<String> sauces = new ArrayList<>();
        sauces.add("mayo");
        sauces.add("barbeque sauce");
        sauces.add("mustard");
        sauces.add("none");
        theModel.addAttribute("sauces", sauces);
        List<String> cheeses = new ArrayList<>();
        cheeses.add("american");
        cheeses.add("swiss");
        cheeses.add("cheddar");
        cheeses.add("pepper jack");
        cheeses.add("none");
        theModel.addAttribute("cheeses", cheeses);

        return "AddSandwichForm";
    }*/

    @PostMapping("/AddSandwich")
    public String addSandwichpost(@Valid @ModelAttribute("sandwich") Sandwich sandwich, BindingResult theBindingResult, Model theModel){
        theModel.addAttribute("sandwich",sandwich);
        if(theBindingResult.hasErrors()){
            return "/AddSandwichForm";
        }
        else{
            SandwichService repo=applicationContext.getBean(SandwichServiceImpl.class);
            repo.save(sandwich);
            String message = "Sandwich Updated";
            theModel.addAttribute("message", message);
            return "confirmation";}
    }


    @GetMapping("/sandwichUpdate")
    public String updateSandwich(@RequestParam("SandwichID") int id, Model theModel){
        SandwichService repo = applicationContext.getBean(SandwichServiceImpl.class);
        //sandwich = null;
        Sandwich theSandwich = repo.findById(id);
        //sandwich1 = theSandwich;
        //sandwich = sandwich1;
        theModel.addAttribute("sandwich", theSandwich);
        List<String> breads = new ArrayList<>();
        breads.add("whole wheat");
        breads.add("sourdough");
        breads.add("white");
        breads.add("wrap");
        breads.add("brioche roll");
        theModel.addAttribute("breads", breads);
        List<String> proteins = new ArrayList<>();
        proteins.add("chicken");
        proteins.add("beef");
        proteins.add("turkey");
        proteins.add("shrimp");
        proteins.add("tofu");
        theModel.addAttribute("proteins", proteins);
        List<String> sauces = new ArrayList<>();
        sauces.add("mayo");
        sauces.add("barbeque sauce");
        sauces.add("mustard");
        sauces.add("none");
        theModel.addAttribute("sauces", sauces);
        List<String> cheeses = new ArrayList<>();
        cheeses.add("american");
        cheeses.add("swiss");
        cheeses.add("cheddar");
        cheeses.add("pepper jack");
        cheeses.add("none");
        theModel.addAttribute("cheeses", cheeses);
        return "sandwichUpdateForm";
    }
    @PostMapping("/sandwichUpdateForm")
    public String submitForm(@Valid @ModelAttribute("sandwich") Sandwich theSandwich, BindingResult bindingResult, Model theModel){
        theModel.addAttribute("sandwich", theSandwich);
        if(bindingResult.hasErrors()){
            return "sandwichUpdateForm";
        }

        else{
            SandwichService sandwichService = applicationContext.getBean(SandwichServiceImpl.class);
            Sandwich newSandwich = sandwichService.findById((int)theSandwich.getId());
            if(newSandwich!=null){

                //theSandwich.setOrders(newSandwich.getOrders());
            }


            sandwichService.save(theSandwich);

            String message = "Sandwich Updated";
            theModel.addAttribute("message", message);
            return "confirmation";}
    }




    @GetMapping("/deleteSandwich")
    public String deleteSandwich(@RequestParam("SandwichID") int theId, Model theModel) {
        SandwichService sandwichService = applicationContext.getBean(SandwichServiceImpl.class);
        OrderService orderService = applicationContext.getBean(OrderServiceImpl.class);
        Sandwich theSandwich = sandwichService.findById(theId);
        Order order = theSandwich.getOrder();
        order.getSandwiches().remove(theSandwich);
        orderService.save(order);
        sandwichService.deleteById(theId);
        String message = "Sandwich Deleted";
        theModel.addAttribute("message", message);
        return "confirmation";
    }

    @GetMapping("/sandwichComplete")
    public String markOrderComplete(@RequestParam("SandwichID") int theID, Model theModel){
        SandwichService sandwichService = applicationContext.getBean(SandwichServiceImpl.class);
        Sandwich sandwich = sandwichService.findById(theID);
        sandwich.setCompleted(true);
        sandwichService.save(sandwich);
        String message = "Sandwich Marked Complete";
        theModel.addAttribute("message", message);
        return "confirmation";
    }


}
