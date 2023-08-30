package org.sid.navire_app_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Affectation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Affectation;
    @ManyToOne
    private Navire navire;
    @ManyToOne
    private Engin engin;
    @ManyToOne
    private Equipe equipe;
    @ManyToOne
    private Grue grue;

}
