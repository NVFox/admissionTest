package com.sprint3.admission_test.infrastructure.adapter.out.mappers.mapstruct;

import com.sprint3.admission_test.application.dto.CreateMedicationDTO;
import com.sprint3.admission_test.application.dto.CreatedMedicationDTO;
import com.sprint3.admission_test.application.ports.out.ICategoryRepository;
import com.sprint3.admission_test.domain.exceptions.NotFoundException;
import com.sprint3.admission_test.domain.model.Category;
import com.sprint3.admission_test.domain.model.Medication;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class MapstructMedicationMapper {
    @Autowired
    private ICategoryRepository categoryRepository;

    public abstract CreatedMedicationDTO getMedicationDTOfromMedication(Medication medication);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", expression = "java(fromName(dto.getCategoryName()))")
    public abstract Medication medicationFromCreateDTO(CreateMedicationDTO dto);

    protected Category fromName(String categoryName) {
        return categoryRepository.findByName(categoryName)
                .orElseThrow(() -> new NotFoundException("Could not find category with name: " + categoryName));
    }
}
