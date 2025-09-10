package dev.java10x.MagicFridgeAI.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum FoodCategory {
    VEGETAL,
    CARNES,
    LATICINIOS,
    BEBIDAS,
    FRUTAS,
    OUTROS;

    @JsonCreator
    public static FoodCategory foodValue(String nameValue){
        return FoodCategory.valueOf(nameValue.toUpperCase());
    }
}
