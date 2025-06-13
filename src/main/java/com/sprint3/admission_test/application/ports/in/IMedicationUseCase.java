package com.sprint3.admission_test.application.ports.in;

import com.sprint3.admission_test.application.dto.CreateMedicationDTO;
import com.sprint3.admission_test.application.dto.CreatedMedicationDTO;
import com.sprint3.admission_test.domain.model.Medication;

public interface IMedicationUseCase {
    Medication getMedicationById(Long id);
    CreatedMedicationDTO createMedication(CreateMedicationDTO medicationDTO);
}
