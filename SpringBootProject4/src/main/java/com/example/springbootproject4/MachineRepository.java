package com.example.springbootproject4;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Sort;

public interface MachineRepository extends JpaRepository<Machine, Long> {

    @Query("SELECT m FROM Machine m WHERE " +
            "LOWER(m.equipmentType) LIKE LOWER(CONCAT('%', ?1, '%')) OR " +
            "LOWER(m.equipmentGroup) LIKE LOWER(CONCAT('%', ?1, '%')) OR " +
            "CAST(m.importDate AS string) LIKE CONCAT('%', ?1, '%') OR " +
            "LOWER(m.driverFullName) LIKE LOWER(CONCAT('%', ?1, '%'))")
    List<Machine> search(String keyword, Sort sort);
}
