package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "file_entity")
public class FileEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    private String name;

    private String type;
    @Lob
    private byte[] content;
}
