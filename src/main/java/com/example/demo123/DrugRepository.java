package com.example.demo123;

import com.example.demo123.model.DrugModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugRepository extends JpaRepository<DrugModel, Long> {


}
