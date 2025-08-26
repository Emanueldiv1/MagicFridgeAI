package dev.java10x.MagicFridgeAI.dto;

import dev.java10x.MagicFridgeAI.enums.FoodCategory;


import java.time.LocalDateTime;

public class FoodItemDTO {

    private long id;

    private String nome;

    private FoodCategory categoria;

    private Integer quantidade;

    private LocalDateTime validade;

}

