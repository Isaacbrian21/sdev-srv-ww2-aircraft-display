package com.example.demo.domain.enums;




public enum Nation {
    USA(0, "United States of America"),
    GERMANY(1, "Germany"),
    JAPAN(2, "Japan"),
    UNITED_KINGDON(3, "United Kingdom"),
    URSS(4, "Soviet Union"),
    ITALY(5, "Italy"),
    FRANCE(6, "France"),
    POLAND(7, "Poland"),
    BRAZIL(8,"Brazil"),
    CANADA(9, "Canada"),
    AUSTRALIA(10, "Australia"),
    NETHERLANDS(11, "Netherlands"),
    CZECHOSLOVAKIA(12, "Czechoslovakia"),
    HUNGARY(13, "Hungary"),
    ROMANIA(14, "Romania");

    private Integer code;       // Código numérico
    private String fullName; // Nome formatado

    Nation(Integer code, String fullName) {
        this.code = code;
        this.fullName = fullName;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
