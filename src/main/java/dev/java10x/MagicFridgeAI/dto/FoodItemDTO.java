package dev.java10x.MagicFridgeAI.dto;

import dev.java10x.MagicFridgeAI.enums.FoodCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FoodItemDTO {

    private long id;

    private String nome;

    private FoodCategory categoria;

    private Integer quantidade;

    private LocalDate validade;

}

