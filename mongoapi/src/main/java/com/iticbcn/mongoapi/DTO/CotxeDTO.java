package com.iticbcn.mongoapi.DTO;

public record CotxeDTO(
        String id,
        String marca,
        String model,
        int any,
        double preu,
        String color
) {}