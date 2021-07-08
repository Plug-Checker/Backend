package com.plugchecker.backend.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Plug {

    @Id
    @GeneratedValue
    private int id;

    @Setter
    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = true)
    private boolean electricity;

}
