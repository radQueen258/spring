package com.example.spring.services;

import com.example.spring.dto.ServiceDto;
import com.example.spring.dto.ServiceForm;

import java.util.List;

public interface ServiceService {

    ServiceDto addService (ServiceForm serviceForm);

    List <ServiceDto> getAllServices();
    List<ServiceDto> search (Integer page, Integer size, String query, String sortParameter, String direction);
}
