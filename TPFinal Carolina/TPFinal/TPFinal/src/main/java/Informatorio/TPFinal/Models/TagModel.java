package Informatorio.TPFinal.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class TagModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id;
    private String nombre;
    @ManyToMany(mappedBy = "tags")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<EmprendimientoModel> emprendimiento = new ArrayList<>();

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
        return emprendimiento;
    }
    public void setEmprendimientos(List<EmprendimientoModel> emprendimiento) {
        this.emprendimiento = emprendimiento;
    }
    @Override
    public String toString() {
       return  "Tag [id=" + id + ", nombre=" + nombre + "]";
    }
}