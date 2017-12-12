package com.ricardococati.repository;

import com.ricardococati.model.CustoNodeGrafo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GrafoRepository extends JpaRepository<CustoNodeGrafo, Integer> {

    CustoNodeGrafo findById(Integer id);

    List<CustoNodeGrafo> findByIdIn(List<Integer> ids);
}
