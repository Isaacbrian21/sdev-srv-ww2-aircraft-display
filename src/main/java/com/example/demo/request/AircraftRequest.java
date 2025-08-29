package com.example.demo.request;


import com.example.demo.domain.enums.AircraftType;
import com.example.demo.domain.enums.Nation;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AircraftRequest {

    private String name;

    private Nation nation;

    private AircraftType aircraftType;

    private String manufacturer;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate firstFlight;

    private Double maxSpeed;

    private Integer flyingRange;

    private String armament;

    private Integer crewSize;

    private Integer serviceStart;

    private Integer serviceEnd;

}