package com.example.demo.dto;


import com.example.demo.domain.enums.AircraftType;
import com.example.demo.domain.enums.Nation;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class AircraftDto {

    private String name;

    private Nation nation;

    private AircraftType aircraftType;

    @Column(nullable = false)
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
