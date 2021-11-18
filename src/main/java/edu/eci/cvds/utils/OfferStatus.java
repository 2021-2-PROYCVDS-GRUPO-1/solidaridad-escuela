package edu.eci.cvds.utils;

public enum OfferStatus {
    ACTIVE("ACTIVE"),
    IN_PROCESS("IN PROCESS"),
    SOLVED("SOLVED"),
    CLOSED("CLOSED");

    private String name;

    OfferStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
