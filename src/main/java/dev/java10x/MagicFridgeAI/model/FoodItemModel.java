package dev.java10x.MagicFridgeAI.model;


import dev.java10x.MagicFridgeAI.enums.FoodCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_food_item")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FoodItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private FoodCategory categoria;

    private Integer quantidade;

    private LocalDateTime validade;


}
