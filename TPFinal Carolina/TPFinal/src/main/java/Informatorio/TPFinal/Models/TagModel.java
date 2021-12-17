package Informatorio.TPFinal.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TagModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id;
    private String nombre;
    @ManyToMany(mappedBy = "tags")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<EmprendimientoModel> emprendimientoModels = new ArrayList<>();

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
    public List<EmprendimientoModel> getEmprendimientos() {
        return emprendimientoModels;
    }
    public void setEmprendimientos(List<EmprendimientoModel> emprendimientoModels) {
        this.emprendimientoModels = emprendimientoModels;
    }
    @Override
    public String toString() {
        return "Tag [emprendimientos=" + emprendimientoModels + ", id=" + id + ", nombre=" + nombre + "]";
    }
}