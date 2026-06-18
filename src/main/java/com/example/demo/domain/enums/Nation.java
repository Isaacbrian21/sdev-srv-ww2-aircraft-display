package com.example.demo.domain.enums;




public enum Nation {
    USA(0, "USA"),
    GERMANY(1, "GERMANY"),
    JAPAN(2, "JAPAN"),
    UK(3, "UK"),
    USSR(4, "USSR"),
    ITALY(5, "ITALY"),
    FRANCE(6, "FRANCE"),
    BRAZIL(7, "BRAZIL"),;

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
