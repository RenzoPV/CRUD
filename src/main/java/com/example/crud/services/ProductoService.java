package com.example.crud.services;

import com.example.crud.entities.Producto;
import com.example.crud.repositories.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository repository;

    public List<Producto> listarTodos() {
        return repository.findAll();
    }

    public Optional<Producto> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Producto guardar(Producto producto) {
        System.out.println("Producto recibido: " + producto);
        return repository.save(producto);
    }

    @Transactional
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public Optional<Producto> actualizar(long id, Producto productoA) {
         return repository.findById(id).map( producto -> {
            producto.setNombre(productoA.getNombre());
            producto.setCantidad(productoA.getCantidad());
            producto.setPrecio(productoA.getPrecio());
            return repository.save(producto);
         });
    }
}
