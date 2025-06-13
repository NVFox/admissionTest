package com.sprint3.admission_test.infrastructure.adapter.out.mappers.impl;

import com.sprint3.admission_test.application.dto.CreateMedicationDTO;
import com.sprint3.admission_test.application.dto.CreatedMedicationDTO;
import com.sprint3.admission_test.application.ports.out.mappers.IMedicationMapper;
import com.sprint3.admission_test.domain.model.Medication;
import com.sprint3.admission_test.infrastructure.adapter.out.mappers.mapstruct.MapstructMedicationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedicationMapperImpl implements IMedicationMapper {
    private final MapstructMedicationMapper mapstructMedicationMapper;

    @Override
    public CreatedMedicationDTO getMedicationDTOfromMedication(Medication medication) {
        return mapstructMedicationMapper.getMedicationDTOfromMedication(medication);
    }

    @Override
    public Medication medicationFromCreateDTO(CreateMedicationDTO createMedicationDTO) {
        return mapstructMedicationMapper.medicationFromCreateDTO(createMedicationDTO);
    }
}
