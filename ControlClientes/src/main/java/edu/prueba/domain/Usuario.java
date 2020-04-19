package edu.prueba.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data
@Table(name="usuario", schema="test")
public class Usuario implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    
    @NotEmpty
    private String username;
    
    @NotEmpty
    private String password;
    
    //esta es la columna que hace la relacion entre las tablas rol y usuario
    @OneToMany
    @JoinColumn(name="id_usuario")
    private List<Rol> roles;
}
