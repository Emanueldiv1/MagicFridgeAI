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
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<FoodItemDTO> ListarItens(){
        List<FoodItemModel> itensModel = foodItemRepository.findAll();
        return itensModel.stream()
                .map(foodItemMapper :: map)
                .collect(Collectors.toList());
    }

    public FoodItemDTO listarItenId(Long id){
        Optional<FoodItemModel> foodId = foodItemRepository.findById(id);
        return foodId.map(foodItemMapper :: map).orElse(null);
    }




}
