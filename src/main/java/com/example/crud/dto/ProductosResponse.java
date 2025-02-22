package com.example.crud.dto;

import com.example.crud.entities.Producto;

import java.util.List;

public class ProductosResponse {
    private int total;
    private List<Producto> productos;

    public ProductosResponse(int total, List<Producto> productos) {
        this.total = total;
        this.productos = productos;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}

