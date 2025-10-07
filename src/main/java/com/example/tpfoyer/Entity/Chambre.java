package com.example.tpfoyer.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Chambre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChambre;
    private Long numeroChambre;

    @Enumerated(EnumType.STRING)
    private TypeChambre typeC;

    @ManyToOne
    @JoinColumn(name = "id_bloc")
    private Bloc bloc;

    @OneToMany(mappedBy = "chambre", cascade = CascadeType.ALL)
    private List<Reservation> reservations;
}
