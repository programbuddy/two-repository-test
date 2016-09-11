package com.programbuddy.tworepositorytest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table
public class Foo implements Serializable {
    @Id
    @Column
    private String id;

    @Column
    private String bar;

    public Foo() {
    }

    public Foo(String id, String bar) {
        this.id = id;
        this.bar = bar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBar() {
        return bar;
    }

    public void setBar(String bar) {
        this.bar = bar;
    }
}



