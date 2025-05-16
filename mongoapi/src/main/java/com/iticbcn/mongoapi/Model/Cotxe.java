package com.iticbcn.mongoapi.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "cotxes")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cotxe implements Serializable {

    @Id
    private String id;
    private String marca;
    private String model;
    private int any;
    private double preu;
    private String color;
}