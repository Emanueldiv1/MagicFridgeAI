package dev.java10x.MagicFridgeAI.controller;


import dev.java10x.MagicFridgeAI.dto.FoodItemDTO;
import dev.java10x.MagicFridgeAI.enums.FoodCategory;
import dev.java10x.MagicFridgeAI.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodItemController {

    @Autowired
    private FoodItemService foodItemService;

    @PostMapping("/register")
    public ResponseEntity <FoodItemDTO> criar(@RequestBody FoodItemDTO foodItemDTO){
        FoodItemDTO newFood = foodItemService.registerFood(foodItemDTO);
        return ResponseEntity.ok(newFood);
    }

    @GetMapping("/categorias")
    public ResponseEntity<List<String>> listarCategorias() {
        return ResponseEntity.ok(foodItemService.ListarCategorias());
    }

}
