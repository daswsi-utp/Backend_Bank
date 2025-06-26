package com.bank.serviceuser.model;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Date;

@Entity
@Table(name = "empleados_metadata")
@Data
public class EmpleadoMetadata {

    @Id
    @Column(name = "id_empleado")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_empleado")
    private Usuario usuario;

    @Column(nullable = false, length = 50)
    private String area;

    @Column(nullable = false, length = 50)
    private String cargo;

    @Column(name = "fecha_ingreso", nullable = false)
    private Date fechaIngreso;
}
