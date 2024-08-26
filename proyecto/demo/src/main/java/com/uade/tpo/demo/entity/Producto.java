package com.uade.tpo.demo.entity;

import java.util.List;

import com.mysql.cj.jdbc.Blob;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    private String nombre;
    private double precio;
    private String descripcion;

    @Lob
    private byte[] foto;

    private int cantidad;

    @OneToOne(mappedBy = "producto", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private CarritoProducto carritoProducto;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<EspecificacionTecnica> especificacionesTecnicas;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<OrdenProducto> ordenProductos;

    // Getters and setters
}
