package com.plugchecker.backend.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "plug")
public class Plug {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Setter
    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = true)
    private boolean electricity;

}
