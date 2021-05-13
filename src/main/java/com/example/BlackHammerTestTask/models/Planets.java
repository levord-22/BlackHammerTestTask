package com.example.BlackHammerTestTask.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Planets {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    public long id;
    public Long lord_id;
    @Column(name = "planet_name", nullable = false, updatable = false)
    public String planet_name;

    public Planets(){
    }
    public Planets(String name){
        this.lord_id = null;
        this.planet_name = name;
    }
    public Planets(long id, String name){
        this.id = id;
        this.planet_name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return planet_name;
    }

    public void setName(String name) {
        this.planet_name = name;
    }

    public long getIdLord() {
        return lord_id;
    }

    public void setIdLord(long idLord) {
        this.lord_id = idLord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planets planet = (Planets) o;
        return id == planet.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
