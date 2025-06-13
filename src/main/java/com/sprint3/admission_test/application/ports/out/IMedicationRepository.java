package com.sprint3.admission_test.application.ports.out;

import com.sprint3.admission_test.domain.model.Medication;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

public interface IMedicationRepository {

    Optional<Medication> findById(Long id);

    Collection<Medication> findByCategory(String category);

    Collection<Medication> findByCategoryAndAfter(String category, LocalDate after);

    Medication save(Medication medication);

}
