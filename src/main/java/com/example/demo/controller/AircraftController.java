package com.example.demo.controller;

import com.example.demo.domain.Aircraft;
import com.example.demo.exception.AircraftNotFoundException;
import com.example.demo.request.AircraftRequest;
import com.example.demo.service.AircraftService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.domain.enums.Nation;

import java.util.List;


public interface AircraftController {


    @PostMapping("/save")
    public ResponseEntity<Aircraft> addAircraft(@RequestBody AircraftRequest request);


    @GetMapping("/list")
    public ResponseEntity<List<Aircraft>> showAllAircrafts(@RequestParam(required = false) Nation nation);


    @GetMapping("/list/{nation}")
    public ResponseEntity<List<Aircraft>> showAllAircraftsByNation(@PathVariable("nation") Nation nation);



    @GetMapping("/{id}")
    public ResponseEntity<Aircraft> getAircraftById(@PathVariable("id") Long id);


    @PutMapping("/change/{id}")
    public ResponseEntity<Aircraft> updateAircraftInformation(@RequestBody AircraftRequest request, @PathVariable("id") Long id);



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id);


}
