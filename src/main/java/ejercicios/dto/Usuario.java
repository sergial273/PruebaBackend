package ejercicios.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    private String nombreUsuario;
    private String usuarioSteam;

    @JsonIgnore
    @OneToMany(mappedBy = "usuarioCreador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Partida> partidasCreadas;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "usuarios_partidas",
        joinColumns = @JoinColumn(name = "id_usuario"),
        inverseJoinColumns = @JoinColumn(name = "id_partida")
    )
    private Set<Partida> partidasUnidas;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getUsuarioSteam() {
        return usuarioSteam;
    }

    public void setUsuarioSteam(String usuarioSteam) {
        this.usuarioSteam = usuarioSteam;
    }

    public List<Partida> getPartidasCreadas() {
        return partidasCreadas;
    }

    public void setPartidasCreadas(List<Partida> partidasCreadas) {
        this.partidasCreadas = partidasCreadas;
    }

    public Set<Partida> getPartidasUnidas() {
        return partidasUnidas;
    }

    public void setPartidasUnidas(Set<Partida> partidasUnidas) {
        this.partidasUnidas = partidasUnidas;
    }
}
