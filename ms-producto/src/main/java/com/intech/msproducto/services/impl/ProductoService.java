package com.intech.msproducto.services.impl;

import com.intech.msproducto.converter.ProductoConverter;
import com.intech.msproducto.dto.ProductoDTO;
import com.intech.msproducto.models.ProductoModel;
import com.intech.msproducto.repositories.IProductoRepository;
import com.intech.msproducto.services.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoRepository productoRepository;

    @Autowired
    private ProductoConverter productoConverter;

    @Override
    public ProductoModel crearProducto(ProductoDTO producto) {
        ProductoModel productoEntity = productoConverter.toEntity(producto);
        return productoRepository.save(productoEntity);
    }

    @Override
    public List<ProductoModel> listarProductos() {
        return (List<ProductoModel>) productoRepository.findAll();
    }

    @Override
    public ProductoModel buscarPorId(long id) {
        Optional<ProductoModel> optionalProducto = productoRepository.findById(id);
        return optionalProducto.orElse(null);
    }

    @Override
    public ProductoModel editarProducto(long id, ProductoDTO producto) {

        if (productoRepository.existsById(id)) {
            producto.setIdProducto(id);
            ProductoModel productoEntity = productoConverter.toEntity(producto);
            return productoRepository.save(productoEntity);
        }
        return null;
    }

    @Override
    public void eliminarProducto(long id) {
        productoRepository.deleteById(id);
    }
}
