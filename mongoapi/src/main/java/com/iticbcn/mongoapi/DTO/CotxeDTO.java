package com.iticbcn.mongoapi.DTO;

public record CotxeDTO(
        String id,
        String marca,
        String model,
        Integer any,
        double preu,
        String color) {
}