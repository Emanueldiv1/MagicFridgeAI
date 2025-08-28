package dev.java10x.MagicFridgeAI.mapper;


import dev.java10x.MagicFridgeAI.dto.FoodItemDTO;
import dev.java10x.MagicFridgeAI.model.FoodItemModel;
import org.springframework.stereotype.Component;

@Component
public class FoodItemMapper {

    public FoodItemModel map(FoodItemDTO foodItemDTO){
        FoodItemModel foodItemModel = new FoodItemModel();

        foodItemModel.setId(foodItemDTO.getId());
        foodItemModel.setNome(foodItemDTO.getNome());
        foodItemModel.setCategoria(foodItemDTO.getCategoria());
        foodItemModel.setQuantidade(foodItemDTO.getQuantidade());
        foodItemModel.setValidade(foodItemDTO.getValidade());

        return foodItemModel;
    }

    public FoodItemDTO map(FoodItemModel foodItemModel) {
        FoodItemDTO foodItemDTO = new FoodItemDTO();

        foodItemDTO.setId(foodItemModel.getId());
        foodItemDTO.setNome(foodItemModel.getNome());
        foodItemDTO.setCategoria(foodItemModel.getCategoria());
        foodItemDTO.setQuantidade(foodItemModel.getQuantidade());
        foodItemDTO.setValidade(foodItemModel.getValidade());

        return foodItemDTO;
    }
}
