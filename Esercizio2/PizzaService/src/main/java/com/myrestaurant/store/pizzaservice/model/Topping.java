package com.myrestaurant.store.pizzaservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Entity
@Builder
@Table(name = "toppings")
public class Topping implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topping_id")
    private Long id;

    @NotBlank
    @Length(max = 255)
    @Column(name = "name")
    private String name;


    @ManyToMany(mappedBy = "toppings" ,cascade = {CascadeType.PERSIST,CascadeType.MERGE} )//mapped by per indicare toppings value su pizza.java
    @JsonIgnore
    private Set<Pizza> pizzas = new HashSet<>();
}
