package com.example.restaurant.contollers;

import com.example.restaurant.domain.Ingredient;
import com.example.restaurant.domain.Sandwich;
import com.example.restaurant.domain.Order;
import com.example.restaurant.repositories.SandwichRepo;
import com.example.restaurant.service.*;
import jakarta.validation.Valid;
import org.aspectj.weaver.ast.Or;
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
public class OrderController {
    @Autowired
    private ApplicationContext applicationContext;
    private SandwichService sandwichService;
    private IngredientService ingredientService;
    //private OrderService orderService;


    public OrderController(SandwichService sandwichService) {
        this.sandwichService = sandwichService;
    }

    @GetMapping("/StartNewOrder")
    public String addSandwich(Model theModel){
        Sandwich newSandwich = new Sandwich();
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
    }

    @PostMapping("/SaveSandwichNewOrder")
    public String addSandwichpost(@Valid @ModelAttribute("sandwich") Sandwich newSandwich, BindingResult theBindingResult, Model theModel){
        if(theBindingResult.hasErrors()){
            return "/AddSandwichForm";
        }
        else{

            OrderService orderService = applicationContext.getBean(OrderServiceImpl.class);
            SandwichService sandwichService1 = applicationContext.getBean(SandwichServiceImpl.class);
            Order order = new Order();
            newSandwich.setOrder(order);
            order.getSandwiches().add(newSandwich);
            orderService.save(order);
            sandwichService1.save(newSandwich);
            String message = "New Order Created";
            theModel.addAttribute("message", message);
            return "confirmation";}
    }


    @GetMapping("/deleteOrder")
    public String deleteOrder(@RequestParam("OrderID") int theId, Model theModel) {
        OrderService orderService = applicationContext.getBean(OrderServiceImpl.class);
        orderService.deleteById(theId);

        String message = "Order Deleted";
        theModel.addAttribute("message", message);
        return "confirmation";
    }

    /*
    @GetMapping("/AddOrder")
    public String addIngredient(Model theModel){
        Order order = new Order();
        theModel.addAttribute("order", order);
        theModel.addAttribute("sandwiches", sandwichService.findAll());
        return "AddOrderForm";
    }

    @PostMapping("/AddOrder")
    public String addOrderpost(@Valid @ModelAttribute("order") Order order, BindingResult theBindingResult, Model theModel){
        theModel.addAttribute("order",order);
        if(theBindingResult.hasErrors()){
            return "/AddOrderForm";
        }
        else{
            OrderService repo=applicationContext.getBean(OrderServiceImpl.class);
            Order newOrder =repo.findById((int)order.getId());
            if(newOrder !=null)order.setSandwiches(newOrder.getSandwiches());
            repo.save(order);

            return "confirmation";}
    } */

    @GetMapping("/AddNewSandwichToOrder")
    public String addSandwichToOrder(@RequestParam("OrderID") int theId, Model theModel){
        //OrderService orderService = applicationContext.getBean(OrderServiceImpl.class);
        //Order theOrder = orderService.findById(theId);
        Sandwich sandwich = new Sandwich();
        //sandwich.setOrder(theOrder);
        //theOrder.getSandwiches().add(sandwich);
        //orderService.save(theOrder);

        theModel.addAttribute("ID", theId);
        theModel.addAttribute("sandwich", sandwich);

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
        return "SandwichToOrderForm";
    }
    @PostMapping("/AddNewSandwichToOrder")
    public String addSandwichToOrder(@Valid @ModelAttribute("sandwich") Sandwich theSandwich, BindingResult theBindingResult, Model theModel){
        if(theBindingResult.hasErrors()){
            return "/mainscreen";
        }
        OrderService orderService = applicationContext.getBean(OrderServiceImpl.class);
        SandwichService sandwichService1 = applicationContext.getBean(SandwichServiceImpl.class);
        Order theOrder = orderService.findById(theSandwich.getHelper());
        theSandwich.setOrder(theOrder);
        theOrder.getSandwiches().add(theSandwich);
        orderService.save(theOrder);
        sandwichService1.save(theSandwich);
        String message = "New Sandwich added to Order";
        theModel.addAttribute("message", message);
        return "confirmation";
    }

    @GetMapping("/OrderComplete")
    public String markOrderComplete(@RequestParam("OrderID") int theID, Model theModel){
        OrderService orderService = applicationContext.getBean(OrderServiceImpl.class);
        Order theOrder = orderService.findById(theID);
        theOrder.setCompleted(true);
        orderService.save(theOrder);
        String message = "Order Marked Complete";
        theModel.addAttribute("message", message);
        return "confirmation";
    }

}
