package com.example.demo.mapper;

import com.example.demo.domain.Aircraft;
import com.example.demo.dto.AircraftDto;
import com.example.demo.request.AircraftRequest;
import org.springframework.stereotype.Component;

@Component
public class AircraftMapper {

    public static AircraftDto AircraftToDto(Aircraft aircraft) {
        return AircraftDto.builder()
                .name(aircraft.getName())
                .aircraftType(aircraft.getAircraftType())
                .nation(aircraft.getNation())
                .manufacturer(aircraft.getManufacturer())
                .firstFlight(aircraft.getFirstFlight())
                .maxSpeed(aircraft.getMaxSpeed())
                .flyingRange(aircraft.getFlyingRange())
                .armament(aircraft.getArmament())
                .crewSize(aircraft.getCrewSize())
                .serviceStart(aircraft.getServiceStart())
                .serviceEnd(aircraft.getServiceEnd()).build();

    }
    public static Aircraft toEntity(AircraftDto dto) {
        return Aircraft.builder()
                .name(dto.getName())
                .nation(dto.getNation())
                .aircraftType(dto.getAircraftType())
                .manufacturer(dto.getManufacturer())
                .firstFlight(dto.getFirstFlight())
                .maxSpeed(dto.getMaxSpeed())
                .flyingRange(dto.getFlyingRange())
                .armament(dto.getArmament())
                .crewSize(dto.getCrewSize())
                .serviceStart(dto.getServiceStart())
                .serviceEnd(dto.getServiceEnd())
                .build();
    }
}