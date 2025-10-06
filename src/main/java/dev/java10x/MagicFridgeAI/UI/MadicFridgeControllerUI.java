package dev.java10x.MagicFridgeAI.UI;


import dev.java10x.MagicFridgeAI.dto.FoodItemDTO;
import dev.java10x.MagicFridgeAI.service.FoodItemService;
import dev.java10x.MagicFridgeAI.service.GeminiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/food/ui")
public class MadicFridgeControllerUI {

    @Autowired
    private FoodItemService foodItemService;

    @Autowired
    private GeminiService geminiService;


    @GetMapping("/listar")
    public String listarFood(Model model){
        List<FoodItemDTO> foodItemDTOS = foodItemService.ListarItens();
        model.addAttribute("Alimentos", foodItemDTOS);
        return "listarAlimentos";
    }


    @DeleteMapping("deletar/{id}")
    public String DeleteFood(@PathVariable Long id, Model model){
        foodItemService.foodItemDelete(id);
        return "redirect:/food/ui/listar";
    }

    @PostMapping("/register")
    public String criar(Model model){
        model.addAttribute("alimentos", new FoodItemDTO());
        return "adicionarAlimentos";
    }

    @GetMapping("/generate")
    public String gerarReceita(Model model) {
        List<FoodItemDTO> foodItem = foodItemService.ListarItens();
        String receita = geminiService.generatRecipe(foodItem).block(); // bloqueia o Mono
        model.addAttribute("receita", receita);
        model.addAttribute("Alimentos", foodItem);
        return "listarAlimentos";
    }





}
