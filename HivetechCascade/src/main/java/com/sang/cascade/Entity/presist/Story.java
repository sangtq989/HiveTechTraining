package com.sang.cascade.Entity.presist;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Story{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "story_name")
    private String storyName;

}
