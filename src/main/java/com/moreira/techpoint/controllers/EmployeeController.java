package com.moreira.techpoint.controllers;

import com.moreira.techpoint.dtos.EmployeeDTO;
import com.moreira.techpoint.dtos.EmployeeMinDTO;
import com.moreira.techpoint.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public ResponseEntity<List<EmployeeMinDTO>> findAll() {
       List<EmployeeMinDTO> result = service.findAll();
       return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> insert(@RequestBody EmployeeDTO dto) {
        dto = service.insert(dto);
        return ResponseEntity.ok(dto);
    }
}