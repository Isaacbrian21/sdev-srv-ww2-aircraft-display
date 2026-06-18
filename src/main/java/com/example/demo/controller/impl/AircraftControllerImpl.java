package com.example.demo.controller.impl;

import com.example.demo.controller.AircraftController;
import com.example.demo.domain.Aircraft;
import com.example.demo.domain.enums.Nation;
import com.example.demo.exception.AircraftNotFoundException;
import com.example.demo.request.AircraftRequest;
import com.example.demo.service.AircraftService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/catalog")
@RequiredArgsConstructor
public class AircraftControllerImpl implements AircraftController {
    private final AircraftService service;


    @PostMapping("/save")
    public ResponseEntity<Aircraft> addAircraft(@RequestBody AircraftRequest request) {
        Aircraft createdAircraft = service.createAircraft(request);
        return new ResponseEntity<>(createdAircraft, HttpStatus.CREATED);
    }


    @GetMapping("/list")
    public ResponseEntity<List<Aircraft>> showAllAircrafts(@RequestParam(required = false) Nation nation) {
        List<Aircraft> aircraftList = service.showAircraftList();
        List<Aircraft> aircraftListByNation = service.showAircraftList();
        if (nation != null) {
            return new ResponseEntity<>(aircraftListByNation, HttpStatus.OK);
        }

        return new ResponseEntity<>(aircraftList, HttpStatus.OK);
    }

    @GetMapping("/list/{nation}")
    public ResponseEntity<List<Aircraft>> showAllAircraftsByNation(@PathVariable("nation") Nation nation) {
        List<Aircraft> aircraftListByNation = service.getAircraftsByNation(nation);

        return new ResponseEntity<>(aircraftListByNation, HttpStatus.OK);

    }


    @GetMapping("/{id}")
    public ResponseEntity<Aircraft> getAircraftById(@PathVariable("id") Long id) {
        Aircraft aircraft = service.getAircraftById(id);
        return ResponseEntity.ok(aircraft);
    }


    @PutMapping("/change/{id}")
    public ResponseEntity<Aircraft> updateAircraftInformation(
            @RequestBody AircraftRequest request, @PathVariable("id") Long id) {

        Aircraft updatedAircraft = service.updateAircraftInfo(request, id);

        return ResponseEntity.ok(updatedAircraft);
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        try {
            service.deleteAircraft(id);

            return ResponseEntity.noContent().build();
        } catch (AircraftNotFoundException e) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
