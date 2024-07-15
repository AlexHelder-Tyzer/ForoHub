package com.alx.foroHub.domain.topico;

import com.alx.foroHub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Topico")
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Usuario autor;
    private Boolean activo;

    public Topico(String titulo, String mensaje, LocalDateTime fecha, Usuario usuario){
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fechaCreacion = fecha;
        this.autor = usuario;
        this.activo = true;

        //this.autor = new Usuario(datosRegistroTopico);
    }

    public void actualizarDatos(DatosActualizarTopico datos) {
        if (datos.titulo() != null){
            this.titulo = datos.titulo();
        }
        if (datos.mensaje() != null){
            this.mensaje = datos.mensaje();
        }
    }

    public void desactivarPaciente() {
        this.activo = false;
    }
}
