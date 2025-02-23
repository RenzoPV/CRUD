package com.example.crud.controllers;

import com.example.crud.dto.ProductosResponse;
import com.example.crud.entities.Producto;
import com.example.crud.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoService service;

    @GetMapping
    public ResponseEntity<ProductosResponse> obtenerProductos() {
        List<Producto> productos = service.listarTodos();
        ProductosResponse response = new ProductosResponse(productos.size(), productos);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable Long id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        System.out.println("Solicitud recibida con producto: " + producto);
        Producto nuevoProducto = service.guardar(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Producto> eliminarProducto(@PathVariable long id) {
        System.out.println("Solicitud de eliminar con producto: " + id);
        if (service.obtenerPorId(id).isPresent()) {
            service.eliminar(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable long id, @RequestBody Producto producto) {
        System.out.println("Solicitud de actualizar con producto: " + producto);
        Optional<Producto> productoActualizado = service.actualizar(id,producto);
        return productoActualizado.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
