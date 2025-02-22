package com.example.crud.tests;

import com.example.crud.entities.Producto;

public class LombokTest {
    public static void main(String[] args) {
        Producto p = new Producto(1L,"Prueba", 100.5, 10);

        // Verificar que los valores se asignaron correctamente
        System.out.println("Id: " + p.getId());
        System.out.println("Nombre: " + p.getNombre());
        System.out.println("Precio: " + p.getPrecio());
        System.out.println("Cantidad: " + p.getCantidad());
    }
}