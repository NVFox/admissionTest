package com.sprint3.admission_test.application.useCases;

import com.sprint3.admission_test.application.dto.CreateMedicationDTO;
import com.sprint3.admission_test.application.dto.CreatedMedicationDTO;
import com.sprint3.admission_test.application.ports.out.mappers.IMedicationMapper;
import com.sprint3.admission_test.application.ports.in.IMedicationUseCase;
import com.sprint3.admission_test.application.ports.out.IMedicationRepository;
import com.sprint3.admission_test.domain.exceptions.NotFoundException;
import com.sprint3.admission_test.domain.model.Medication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Service
public class MedicationUseCaseImpl implements IMedicationUseCase {

    @Autowired
    private IMedicationRepository medicationRepository;

    @Autowired
    private IMedicationMapper medicationMapper;

    @Override
    public Medication getMedicationById(Long id) {
        return medicationRepository.findById(id).orElseThrow(() -> new NotFoundException(
                "Could not find medication with ID: " + id
        ));
    }

    @Override
    public CreatedMedicationDTO createMedication(CreateMedicationDTO medicationDTO) {
        Medication medication = medicationMapper.medicationFromCreateDTO(medicationDTO);
        return medicationMapper.getMedicationDTOfromMedication(medicationRepository.save(medication));
    }

    @Override
    public Collection<Medication> getMedicationByCategoryAndAfter(String category, LocalDate after) {
        if (after == null)
            return medicationRepository.findByCategory(category);

        return medicationRepository.findByCategoryAndAfter(category, after);
    }
}
