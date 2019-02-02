package com.example.springbootfun.repositories;

import com.example.springbootfun.entities.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, Long> {
    /* Custom GPL code will be generated behind the scene when using findBy.
    *  @see https://stackoverflow.com/questions/47090132/spring-jdbctemplate-passing-constant-value-to-an-query-method?rq=1 */
    List<Treatment> findByPriceForTreatmentLessThan(double price);
}
