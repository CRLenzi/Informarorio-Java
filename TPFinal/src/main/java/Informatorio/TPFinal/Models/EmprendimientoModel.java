package Informatorio.TPFinal.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Where(clause = "activo = true")
public class EmprendimientoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "nombre no deberia estar vacio")
    private String nombre;
    @NotEmpty(message = "descripcion no deberia estar vacio")
    private String descripcion;
    @NotEmpty(message = "contenido no deberia estar vacio")
    private String contenido;
    @CreationTimestamp
    private LocalDateTime fechaDeCreacion;
    private LocalDateTime ultimaModificacion;
    @NotNull
    private Double objetivo;
    private Boolean publicado;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Boolean activo = true;
    @NotNull
    private String url;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<TagModel> tags = new ArrayList<>();
    @ManyToOne(fetch = FetchType.LAZY)
    private UsuarioModel creador;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "emprendimientoId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VotoModel> votos = new ArrayList<>();
    private Integer contadorDeVotos = 0;
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<EventoModel> eventos;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getContenido() {
        return contenido;
    }
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    public LocalDateTime getFechaDeCreacion() {
        return fechaDeCreacion;
    }
    public void setFechaDeCreacion(LocalDateTime fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }
    public LocalDateTime getUltimaModificacion() {
        return ultimaModificacion;
    }
    public void setUltimaModificacion(LocalDateTime ultimaModificacion) {
        this.ultimaModificacion = ultimaModificacion;
    }
    public Double getObjetivo() {
        return objetivo;
    }
    public void setObjetivo(Double objetivo) {
        this.objetivo = objetivo;
    }
    public Boolean isPublicado() {
        return publicado;
    }
    public void setPublicado(Boolean publicado) {
        this.publicado = publicado;
    }
    public Boolean isActivo() {
        return activo;
    }
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public List<TagModel> getTags() {
        return tags;
    }
    public void setTags(List<TagModel> tags) {
        this.tags = tags;
    }
    public void addTags(TagModel tag) {
        tags.add(tag);
        tag.getEmprendimientos().add(this);
    }
    public String getCreador() {
        return creador.getEmail();
    }
    public void setCreador(UsuarioModel creador) {
        this.creador = creador;
    }
    public List<VotoModel> getVotos() {
        return votos;
    }
    public void setVotos(List<VotoModel> votos) {
        this.votos = votos;
    }
    public Integer getContadorDeVotos() {
        return contadorDeVotos;
    }
    public void setContadorDeVotos(Integer contadorDeVotos) {
        this.contadorDeVotos = contadorDeVotos;
    }
    public List<EventoModel> getEventos() {
        return eventos;
    }
    public void setEventos(List<EventoModel> eventos) {
        this.eventos = eventos;
    }
    public void addEvento(EventoModel evento) {
        if (this.eventos == null) {
            this.eventos = new ArrayList<>();
        }
        this.eventos.add(evento);
    }
    @Override
    public String toString() {
        return "Emprendimiento [activo=" + activo + ", contadorDeVotos=" + contadorDeVotos + ", contenido=" + contenido
                + ", creador=" + creador + ", descripcion=" + descripcion + ", eventos=" + eventos
                + ", fechaDeCreacion=" + fechaDeCreacion + ", id=" + id + ", nombre=" + nombre + ", objetivo="
                + objetivo + ", publicado=" + publicado + ", tags=" + tags + ", ultimaModificacion="
                + ultimaModificacion + ", url=" + url + ", votos=" + votos + "]";
    }   
}