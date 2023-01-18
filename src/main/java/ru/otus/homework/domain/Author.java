package ru.otus.homework.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",unique = true)
    private String name;

    @OneToMany(mappedBy = "author",fetch = FetchType.LAZY)
    private List<Book> books;

    public Author(String name){
        this.name = name;
    }


    @Override
    public String toString() {
        return id + " " + name + "\n";
    }

}