package com.tien.ss05.model.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class FruitDTO {
    private Long id;
    private String name;
    private Double price;
    private Boolean status;
    private LocalDate createdAt;
}
