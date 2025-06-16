
package com.naukri.database_api.controllers;

import com.naukri.database_api.models.Company;
import com.naukri.database_api.repositories.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/company")
public class CompanyController {

    CompanyRepo companyRepository;

    @Autowired
    public CompanyController(CompanyRepo companyRepository) {
        this.companyRepository = companyRepository;
    }

    @PostMapping("/save")
    public ResponseEntity createCompany(@RequestBody Company company) {
        companyRepository.save(company);
        return new ResponseEntity(company, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCompanyById(@PathVariable UUID id) {
        Company company = companyRepository.findById(id).orElse(null);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity updateCompany(@RequestBody Company company) {
        companyRepository.save(company);
        return new ResponseEntity(company, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCompanyById(@PathVariable UUID id) {
        companyRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
