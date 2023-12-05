package ejercicios.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "partidas")
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    private Long idCreador;
    private String nombrePartida;


    @JsonIgnoreProperties({"partidasCreadas", "partidasUnidas"})
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuarioCreador;

    @JsonIgnoreProperties("partidas")
    @ManyToOne
    @JoinColumn(name = "videojuego_id")
    private Videojuego videojuego;

    @JsonIgnore
    @OneToMany(mappedBy = "partida", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mensaje> mensajes;
    
    @JsonIgnore
    @ManyToMany(mappedBy = "partidasUnidas")
    private Set<Usuario> usuariosUnidos;
    
    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCreador() {
        return idCreador;
    }

    public void setIdCreador(Long idCreador) {
        this.idCreador = idCreador;
    }

    public String getNombrePartida() {
        return nombrePartida;
    }

    public void setNombrePartida(String nombrePartida) {
        this.nombrePartida = nombrePartida;
    }

    public Usuario getUsuarioCreador() {
        return usuarioCreador;
    }

    public void setUsuarioCreador(Usuario usuarioCreador) {
        this.usuarioCreador = usuarioCreador;
    }

    public Videojuego getVideojuego() {
        return videojuego;
    }

    public void setVideojuego(Videojuego videojuego) {
        this.videojuego = videojuego;
    }

    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }
}

