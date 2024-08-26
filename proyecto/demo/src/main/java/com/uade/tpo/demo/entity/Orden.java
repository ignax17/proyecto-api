package com.uade.tpo.demo.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data

@Table(name = "ordenes")
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrden;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Temporal(TemporalType.DATE)
    private Date fechaOrden;

    private String metodoPago;
    private double descuento;
    private double total;
    private double totalConDescuento;
    private String estado;

    @OneToMany(mappedBy = "orden", cascade = CascadeType.ALL)
    private List<OrdenProducto> ordenProductos;

    // Getters and setters
}
