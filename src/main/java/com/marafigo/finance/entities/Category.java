package com.marafigo.finance.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_category")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode (of = "id")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
