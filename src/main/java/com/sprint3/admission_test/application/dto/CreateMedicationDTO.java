package com.sprint3.admission_test.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CreateMedicationDTO {
    @NotBlank
    @Size(min = 5, max = 100)
    private String name;

    @NotBlank
    @Size(min = 30, max = 255)
    private String description;

    @NotNull
    @Digits(integer = 12, fraction = 2)
    @Min(value = 1)
    private BigDecimal price;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate expirationDate;

    @NotBlank
    @Size(min = 3, max = 50)
    private String categoryName;
}
