package com.sprint3.admission_test.infrastructure.adapter.out.persistence.jpaRepository;

import com.sprint3.admission_test.domain.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Collection;

public interface MedicationJpaRepository extends JpaRepository<Medication, Long> {
    Collection<Medication> findAllByCategoryName(String categoryName);
    Collection<Medication> findAllByCategoryNameAndExpirationDateAfter(String categoryName, LocalDate expirationDate);
}
