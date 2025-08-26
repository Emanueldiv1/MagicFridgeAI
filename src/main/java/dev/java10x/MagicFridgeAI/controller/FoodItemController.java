package dev.java10x.MagicFridgeAI.controller;


import dev.java10x.MagicFridgeAI.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/food")
public class FoodItemController {

    @Autowired
    private FoodItemService foodItemService;



}
