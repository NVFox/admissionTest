package com.sprint3.admission_test.infrastructure.adapter.in.web;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sprint3.admission_test.application.dto.CreateMedicationDTO;
import com.sprint3.admission_test.application.dto.CreatedMedicationDTO;
import com.sprint3.admission_test.application.ports.in.IMedicationUseCase;
import com.sprint3.admission_test.domain.model.Medication;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collection;

@RestController
@RequestMapping("/api/medications")
public class MedicationController {

    @Autowired
    private IMedicationUseCase medicationUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<Medication> getMedicationById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(medicationUseCase.getMedicationById(id));
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<Collection<Medication>> getMedicationsByCategory(@PathVariable String category,
                                                                           @RequestParam(name = "expiration-after", required = false)
                                                                           @JsonFormat(pattern = "yyyy-MM-dd") LocalDate expirationDate) {
        return ResponseEntity.ok(medicationUseCase.getMedicationByCategoryAndAfter(category, expirationDate));
    }

    @PostMapping
    public ResponseEntity<CreatedMedicationDTO> createMedication(@RequestBody @Valid CreateMedicationDTO createMedicationDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(medicationUseCase.createMedication(createMedicationDTO));
    }
}
