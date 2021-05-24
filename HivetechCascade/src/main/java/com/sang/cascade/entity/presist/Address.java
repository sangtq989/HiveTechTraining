package com.sang.cascade.entity.presist;


import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int houseNumber;
    private String city;

    @ManyToOne(fetch = FetchType.LAZY)
    private Person person;
}