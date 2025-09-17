package dev.java10x.MagicFridgeAI.controller;


import dev.java10x.MagicFridgeAI.dto.FoodItemDTO;
import dev.java10x.MagicFridgeAI.enums.FoodCategory;
import dev.java10x.MagicFridgeAI.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/listar")
    public ResponseEntity<List<FoodItemDTO>> listarFood(){
        List<FoodItemDTO> foodItemDTOS = foodItemService.ListarItens();
        return ResponseEntity.ok(foodItemDTOS);
    }

    @GetMapping("/itens/{id}")
    public ResponseEntity<?> listarFoodId(@PathVariable Long id){
        FoodItemDTO foodId = foodItemService.listarItenId(id);
        if (foodId != null){
            return ResponseEntity.ok(foodId.getNome());
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Esse ID: " + id + " não existe");
        }
    }

    @PutMapping("editar/{id}")
    public ResponseEntity<?> editarFood(@PathVariable long id, @RequestBody FoodItemDTO foodItemDTO){
        FoodItemDTO foodItemUp = foodItemService.listarItenId(id);
        if (foodItemUp != null){
            FoodItemDTO foodUpdate = foodItemService.foodItemUpdate(id, foodItemDTO);
            return ResponseEntity.ok(foodUpdate);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Esse item não existe");
        }
    }

    @DeleteMapping("deletar/{id}")
    public ResponseEntity<String> DeleteFood(@PathVariable Long id){
       boolean delete = foodItemService.foodItemDelete(id);
       return delete ? ResponseEntity.ok("Item deletado com sucesso") : ResponseEntity.status(
               HttpStatus.NOT_FOUND).body("Item não encontrado");
    }

}
