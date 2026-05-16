package com.example.demo.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum AircraftType {
    FIGHTER("FIGHTER", "Fighter"),
    DIVE_BOMBER("DIVE_BOMBER", "Dive Bomber"),
    JET_FIGHTER("JET_FIGHTER", "Jet Fighter"),
    MULTIROLE("MULTIROLE", "Multirole"),
    ATTACK("ATTACK", "Attack"),
    BOMBER("BOMBER", "Bomber"),
    STRATEGIC_BOMBER("STRATEGIC_BOMBER", "Strategic Bomber"),
    TORPEDO_BOMBER("TORPEDO_BOMBER", "Torpedo Bomber"),
    RECONNAISSANCE_AIRCRAFT("RECONNAISSANCE_AIRCRAFT", "Reconnaissance Aircraft");

    private final String code;         // Código armazenado no banco
    private final String description;  // Nome legível

    // Método para buscar o enum a partir de um código
    public static AircraftType fromString(String code) {
        for (AircraftType type : AircraftType.values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown code: " + code);
    }
}
