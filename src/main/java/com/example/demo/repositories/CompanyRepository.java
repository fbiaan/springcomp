package com.example.demo.repositories;


import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Company;



@Repository

public interface CompanyRepository extends CrudRepository<Company, Long> {
    //public abstract ArrayList<Company> findByPrioridad(Integer prioridad);

}