package com.example.tpfoyer.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;
    private Date anneeUniversitaire;
    private boolean estValide;

    @ManyToOne
    @JoinColumn(name = "id_chambre")
    private Chambre chambre;

    @ManyToMany
    @JoinTable(
            name = "reservation_etudiant",
            joinColumns = @JoinColumn(name = "id_reservation"),
            inverseJoinColumns = @JoinColumn(name = "id_etudiant")
    )
    private List<Etudiant> etudiants;

}
