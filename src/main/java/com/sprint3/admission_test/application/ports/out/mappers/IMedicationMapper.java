package com.sprint3.admission_test.application.ports.out.mappers;

import com.sprint3.admission_test.application.dto.CreateMedicationDTO;
import com.sprint3.admission_test.application.dto.CreatedMedicationDTO;
import com.sprint3.admission_test.domain.model.Medication;

public interface IMedicationMapper {
    CreatedMedicationDTO getMedicationDTOfromMedication(Medication medication);
    Medication medicationFromCreateDTO(CreateMedicationDTO createMedicationDTO);
}
