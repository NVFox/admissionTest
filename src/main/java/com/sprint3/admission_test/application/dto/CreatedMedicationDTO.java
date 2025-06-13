package com.sprint3.admission_test.application.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.sprint3.admission_test.domain.model.Category;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CreatedMedicationDTO {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private LocalDate expirationDate;
    private Category category;
}
