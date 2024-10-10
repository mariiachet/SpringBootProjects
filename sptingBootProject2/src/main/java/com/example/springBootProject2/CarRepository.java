package com.example.springBootProject2;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Sort;

public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("SELECT c FROM Car c WHERE " +
            "LOWER(c.brand) LIKE LOWER(CONCAT('%', ?1, '%')) OR " +
            "CAST(c.yearOfProduction AS string) LIKE CONCAT('%', ?1, '%') OR " +
            "(CAST(c.regDate AS string) = ?1) OR " +
            "LOWER(c.ownerName) LIKE LOWER(CONCAT('%', ?1, '%'))")
    List<Car> search(String keyword, Sort sort);
}