package org.iesfm.institutoScanner;

import java.util.List;
import java.util.Objects;

public class Instituto {

    private String name;
    private List<Group> groups;

    public Instituto(String name, List<Group> groups) {
        this.name = name;
        this.groups = groups;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instituto instituto = (Instituto) o;
        return Objects.equals(name, instituto.name) && Objects.equals(groups, instituto.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, groups);
    }

    @Override
    public String toString() {
        return "Instituto{" +
                "name='" + name + '\'' +
                ", groups=" + groups +
                '}';
    }
}
