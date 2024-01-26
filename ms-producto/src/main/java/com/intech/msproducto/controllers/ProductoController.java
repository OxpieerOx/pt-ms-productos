package com.intech.msproducto.controllers;

import com.intech.msproducto.dto.ProductoDTO;
import com.intech.msproducto.models.ProductoModel;
import com.intech.msproducto.services.IProductoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    private final Logger logger = LoggerFactory.getLogger(ProductoController.class);

    @PostMapping("/crear")
    public ResponseEntity<ProductoModel> crearProducto(@RequestBody ProductoDTO productoDTO) {
        try {
            ProductoModel productoCreado = productoService.crearProducto(productoDTO);
            return new ResponseEntity<>(productoCreado, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Error al crear el producto", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ProductoModel>> listarProductos() {
        try {
            List<ProductoModel> productos = productoService.listarProductos();
            return new ResponseEntity<>(productos, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error al obtener la lista de productos", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<ProductoModel> buscarPorId(@PathVariable long id) {
        try {
            ProductoModel producto = productoService.buscarPorId(id);
            if (producto != null) {
                return new ResponseEntity<>(producto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error("Error al buscar el producto por ID", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<ProductoModel> editarProducto(@PathVariable long id, @RequestBody ProductoDTO productoDTO) {
        try {
            ProductoModel productoEditado = productoService.editarProducto(id, productoDTO);
            if (productoEditado != null) {
                return new ResponseEntity<>(productoEditado, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error("Error al editar el producto", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable long id) {
        try {
            productoService.eliminarProducto(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error al eliminar el producto", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
