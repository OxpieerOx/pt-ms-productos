package com.intech.msproducto.dto;

public class ProductoDTO {

    private Long idProducto;
    private String name;
    private Double price;
    private Long stock;
    private Long createdBy;


    public ProductoDTO() {
    }


    public ProductoDTO(Long idProducto, String name, Double price, Long stock, Long createdBy) {
        this.idProducto = idProducto;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.createdBy = createdBy;
    }


    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }
}
