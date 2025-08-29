package com.example.demo.domain;

import com.example.demo.domain.enums.AircraftType;
import com.example.demo.domain.enums.Nation;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Aircraft {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Nation nation;


    @ElementCollection(targetClass = AircraftType.class)
    @CollectionTable(
            name = "aircraft_aircraft_types",
            joinColumns = @JoinColumn(name = "aircraft_id")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "aircraft_type", nullable = false)
    private List<AircraftType> aircraftType;

    @Column(nullable = false)
    private String manufacturer;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate firstFlight;

    @Column(nullable = false)
    private Double maxSpeed; // km/h

    private Integer flyingRange; // Alcance em km

    private String armament;

    private Integer crewSize;

    private Integer serviceStart;

    private Integer serviceEnd;



}
