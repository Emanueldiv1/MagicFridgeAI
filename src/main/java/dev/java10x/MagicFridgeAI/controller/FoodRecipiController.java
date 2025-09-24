package dev.java10x.MagicFridgeAI.controller;

import dev.java10x.MagicFridgeAI.dto.FoodItemDTO;
import dev.java10x.MagicFridgeAI.service.FoodItemService;
import dev.java10x.MagicFridgeAI.service.GeminiService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class FoodRecipiController {

    @Autowired
    private GeminiService geminiService;

    @Autowired
    private FoodItemService foodItemService;

    @GetMapping("generate")
    public Mono<ResponseEntity<String>> generatRecipe(){
        List<FoodItemDTO> foodItem = foodItemService.ListarItens();
        return geminiService.generatRecipe(foodItem)
                .map(recipe -> ResponseEntity.ok(recipe))
                .defaultIfEmpty(ResponseEntity.noContent().build());
    }

}
