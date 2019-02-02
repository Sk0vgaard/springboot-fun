package com.example.springbootfun.repositories;

import com.example.springbootfun.entities.BookedTreatment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookedTreatmentRepository extends JpaRepository<BookedTreatment, Long> {
}
