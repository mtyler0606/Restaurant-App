package com.example.restaurant.contollers;


import com.example.restaurant.domain.Sandwich;
import com.example.restaurant.domain.Order;
import com.example.restaurant.service.OrderService;
import com.example.restaurant.service.SandwichService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainscreenController {


    private SandwichService sandwichService;
    private OrderService orderService;

    public MainscreenController(SandwichService sandwichService, OrderService orderService) {
        this.sandwichService = sandwichService;
        this.orderService = orderService;
    }

    /*@GetMapping("/")
    public String slash(){
        return "main";
    }*/

    @GetMapping("/mainscreen")
    public String main(Model themodel, @Param("sandwichkeyword") String sandwichkeyword, @Param("orderkeyword") String orderkeyword){
        List<Sandwich> sandwichList = sandwichService.listAll(sandwichkeyword);
        List<Sandwich> openSandwichList = new ArrayList<>();
        List<Sandwich> closedSandwichList = new ArrayList<>();
        for(Sandwich sandwich: sandwichList){
            if(sandwich.isCompleted()){
                closedSandwichList.add(sandwich);
            } else { openSandwichList.add(sandwich); }
        }
        themodel.addAttribute("sandwiches", sandwichList);
        themodel.addAttribute("sandwichkeyword", sandwichkeyword);

        List<Order> orderList = orderService.listAll(orderkeyword);
        List<Order> openOrderList = new ArrayList<>();
        List<Order> closedOrderList = new ArrayList<>();
        for(Order order: orderList){
            if(order.isCompleted()){
                closedOrderList.add(order);
            } else { openOrderList.add(order); }
        }
        themodel.addAttribute("orders", orderList);
        themodel.addAttribute("orderkeyword", orderkeyword);
        themodel.addAttribute("openOrders", openOrderList);
        themodel.addAttribute("closedOrders", closedOrderList);
        themodel.addAttribute("openSandwiches", openSandwichList);
        themodel.addAttribute("closedSandwiches", closedSandwichList);
        return "mainscreen";
    }
}
