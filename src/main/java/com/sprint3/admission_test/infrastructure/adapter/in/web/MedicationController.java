package com.sprint3.admission_test.infrastructure.adapter.in.web;

import com.sprint3.admission_test.application.dto.CreateMedicationDTO;
import com.sprint3.admission_test.application.dto.CreatedMedicationDTO;
import com.sprint3.admission_test.application.ports.in.IMedicationUseCase;
import com.sprint3.admission_test.domain.model.Medication;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/medications")
public class MedicationController {

    @Autowired
    private IMedicationUseCase medicationUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<Medication> getMedicationById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(medicationUseCase.getMedicationById(id));
    }

    @PostMapping
    public ResponseEntity<CreatedMedicationDTO> createMedication(@RequestBody @Valid CreateMedicationDTO createMedicationDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(medicationUseCase.createMedication(createMedicationDTO));
    }
}
