package com.sang.cascade.entity.presist;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;

    @Column(name = "book_name")
    private String bookName;

    @OneToMany(fetch= FetchType.LAZY)
    @JoinColumn(name = "book_id",referencedColumnName="bookId")
    private List<Story> storyList = new ArrayList<>();

}