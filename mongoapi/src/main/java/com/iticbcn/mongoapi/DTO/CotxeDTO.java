package com.iticbcn.mongoapi.DTO;

// public record CotxeDTO(
//         String id,
//         String marca,
//         String model,
//         int any,
//         double preu,
//         String color) {
// }

public class CotxeDTO {
    private String id;
    private String marca;
    private String model;
    private int any;
    private double preu;
    private String color;

    public CotxeDTO(String id, String marca, String model, int any, double preu, String color) {
        this.id = id;
        this.marca = marca;
        this.model = model;
        this.any = any;
        this.preu = preu;
        this.color = color;
    }

    public String getId() {
        return id;
    }



        public void setId(String id) {
                this.id = id;
        }       
        public String getMarca() {
                return marca;
        }
        public void setMarca(String marca) {
                this.marca = marca;
        }
        public String getModel() {
                return model;
        }      
        public void setModel(String model) {
                this.model = model;
        }
        public int getAny() {
                return any;
        }
        public void setAny(int any) {
                this.any = any;
        }
        public double getPreu() {
                return preu;
        }
        public void setPreu(double preu) {
                this.preu = preu;
        }
        public String getColor() {
                return color;
        }
        public void setColor(String color) {
                this.color = color;
        }

        @Override
        public String toString() {
                return "CotxeDTO{" +
                        "id='" + id + '\'' +
                        ", marca='" + marca + '\'' +
                        ", model='" + model + '\'' +
                        ", any=" + any +
                        ", preu=" + preu +
                        ", color='" + color + '\'' +
                        '}';
        }

}