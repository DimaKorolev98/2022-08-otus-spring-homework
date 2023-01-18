package ru.otus.homework.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

//    @OneToMany(mappedBy = "book",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private List<Comment> comments;


    public Book(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return id +
                " Наименование: " + title +
                ". Автор: " + author.getName()
                +
                ". Жанр: " + genre.getName()
//                + ". Коментарии:" + comments.toString()
                + "\n";
    }

    public String toStringWithCommentsCount() {
        return id +
                " Наименование: " + title +
                ". Автор: " + author.getName() +
                ". Жанр: " + genre.getName()
                + "\n";
    }

}