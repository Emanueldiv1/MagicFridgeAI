package dev.java10x.MagicFridgeAI.service;

import dev.java10x.MagicFridgeAI.Repository.FoodItemRepository;
import dev.java10x.MagicFridgeAI.dto.FoodItemDTO;
import dev.java10x.MagicFridgeAI.enums.FoodCategory;
import dev.java10x.MagicFridgeAI.mapper.FoodItemMapper;
import dev.java10x.MagicFridgeAI.model.FoodItemModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FoodItemService {

    @Autowired
    private FoodItemRepository foodItemRepository;

    @Autowired
    private FoodItemMapper foodItemMapper;

    public FoodItemDTO registerFood(FoodItemDTO foodItemDTO){
        FoodItemModel foodItemModel = foodItemMapper.map(foodItemDTO);
        foodItemRepository.save(foodItemModel);
        return foodItemMapper.map(foodItemModel);
    }

    public List<String> ListarCategorias(){
        return Arrays.stream(FoodCategory.values())
                .map(Enum :: name)
                .toList();

    }




}
