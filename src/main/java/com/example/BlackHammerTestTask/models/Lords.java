package com.example.BlackHammerTestTask.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Lords {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    public long id;
    public String lord_name;
    public int age;


    public Lords(){
    }
    public Lords( String name, int age){
        this.lord_name = name;
        this.age= age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return lord_name;
    }

    public void setName(String name) {
        this.lord_name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lords lord = (Lords) o;
        return id == lord.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
