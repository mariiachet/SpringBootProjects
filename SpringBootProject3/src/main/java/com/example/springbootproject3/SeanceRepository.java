package com.example.springbootproject3;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Sort;

public interface SeanceRepository extends JpaRepository<Seance, Long> {

    @Query("SELECT s FROM Seance s WHERE " +
            "LOWER(s.movieTitle) LIKE LOWER(CONCAT('%', ?1, '%')) OR " +
            "LOWER(s.studio) LIKE LOWER(CONCAT('%', ?1, '%')) OR " +
            "CAST(s.sessionDateTime AS string) LIKE CONCAT('%', ?1, '%')")
    List<Seance> search(String keyword, Sort sort);
}

