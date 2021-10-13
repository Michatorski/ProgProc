package org.iesfm.ioc;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Instituto {

    private String nombre;
    private String direccion;

    @JsonCreator
    public Instituto(
            @JsonProperty("nombre") String nombre,
            @JsonProperty("direccion") String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instituto instituto = (Instituto) o;
        return Objects.equals(nombre, instituto.nombre) && Objects.equals(direccion, instituto.direccion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, direccion);
    }
}
