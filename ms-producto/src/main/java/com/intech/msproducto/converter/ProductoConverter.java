package com.intech.msproducto.converter;

import com.intech.msproducto.dto.ProductoDTO;
import com.intech.msproducto.models.ProductoModel;
import org.springframework.stereotype.Component;

@Component
public class ProductoConverter extends AbstractConverter<ProductoModel, ProductoDTO> {


    @Override
    public ProductoModel toEntity(ProductoDTO dto) {
        ProductoModel producto = new ProductoModel();
        producto.setIdProducto(dto.getIdProducto());
        producto.setName(dto.getName());
        producto.setPrice(dto.getPrice());
        producto.setStock(dto.getStock());
        producto.setCreatedBy(dto.getCreatedBy());
        return producto;
    }

    @Override
    public ProductoDTO toDTO(ProductoModel entity) {
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setIdProducto(entity.getIdProducto());
        productoDTO.setName(entity.getName());
        productoDTO.setPrice(entity.getPrice());
        productoDTO.setStock(entity.getStock());
        productoDTO.setCreatedBy(entity.getCreatedBy());
        return productoDTO;
    }
}
