package org.sid.navire_app_backend.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Equipe {
    @Id
    private String matricule_Equipe;
    private int Nombre_Membre;
    @OneToMany(mappedBy = "equipe")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Affectation> affectations;
}
