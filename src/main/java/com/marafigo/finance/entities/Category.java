package com.marafigo.finance.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_category")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode (of = "id")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "category")
    private Set<Transaction> transactions = new HashSet<>();

}
