package com.intech.msproducto.services;

import com.intech.msproducto.dto.ProductoDTO;
import com.intech.msproducto.models.ProductoModel;

import java.util.List;

public interface IProductoService {


    ProductoModel crearProducto(ProductoDTO productoDTO);


    List<ProductoModel> listarProductos();


    ProductoModel buscarPorId(long id);


    ProductoModel editarProducto(long id, ProductoDTO  productoDTO);

    // Eliminar un producto por su ID
    void eliminarProducto(long id);
}