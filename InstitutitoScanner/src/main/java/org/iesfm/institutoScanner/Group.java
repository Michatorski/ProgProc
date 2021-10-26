package org.iesfm.institutoScanner;

import java.util.List;
import java.util.Objects;

public class Group {
    private String letra;
    private String curso;
    private List<Student> alumnos;

    public Group(String letra, String curso, List<Student> alumnos) {
        this.letra = letra;
        this.curso = curso;
        this.alumnos = alumnos;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public List<Student> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Student> alumnos) {
        this.alumnos = alumnos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(letra, group.letra) && Objects.equals(curso, group.curso) && Objects.equals(alumnos, group.alumnos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(letra, curso, alumnos);
    }

    @Override
    public String toString() {
        return "Group{" +
                "letra='" + letra + '\'' +
                ", curso='" + curso + '\'' +
                ", alumnos=" + alumnos +
                '}';
    }
}
