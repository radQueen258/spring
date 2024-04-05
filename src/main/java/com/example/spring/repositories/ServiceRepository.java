package com.example.spring.repositories;

import com.example.spring.models.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ServiceRepository extends JpaRepository<Service, Long> {

    @Query("select service from Service service where (:q = 'empty' or UPPER(service.name) like UPPER(concat('%', :q, '%')))")
    Page<Service> search ( String q,Pageable pageable);
}
