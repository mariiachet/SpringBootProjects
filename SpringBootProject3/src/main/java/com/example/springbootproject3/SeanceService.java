package com.example.springbootproject3;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

@Service
public class SeanceService {

    @Autowired
    private SeanceRepository repo;

    public List<Seance> listAll(String keyword) {
        return listAll(keyword, null, null);
    }

    public List<Seance> listAll(String keyword, String sortField) {
        return listAll(keyword, sortField, null);
    }

    public List<Seance> listAll(String keyword, String sortField, String sortOrder) {
        keyword = (keyword == null) ? "" : keyword;
        sortField = (sortField == null || sortField.isEmpty()) ? "id" : sortField;
        sortOrder = (sortOrder == null || sortOrder.isEmpty()) ? "asc" : sortOrder;

        Sort.Direction direction = Sort.Direction.ASC;
        if ("desc".equalsIgnoreCase(sortOrder)) {
            direction = Sort.Direction.DESC;
        }

        Sort sort = Sort.by(direction, sortField);
        return repo.search(keyword, sort);
    }


    public void save(Seance seance) {
        repo.save(seance);
    }


    public Seance get(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}

