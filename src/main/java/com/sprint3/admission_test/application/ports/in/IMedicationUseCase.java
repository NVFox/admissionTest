package com.sprint3.admission_test.application.ports.in;

import com.sprint3.admission_test.application.dto.CreateMedicationDTO;
import com.sprint3.admission_test.application.dto.CreatedMedicationDTO;
import com.sprint3.admission_test.domain.model.Medication;

import java.time.LocalDate;
import java.util.Collection;

public interface IMedicationUseCase {
    Medication getMedicationById(Long id);
    CreatedMedicationDTO createMedication(CreateMedicationDTO medicationDTO);
    Collection<Medication> getMedicationByCategoryAndAfter(String category, LocalDate after);
}
