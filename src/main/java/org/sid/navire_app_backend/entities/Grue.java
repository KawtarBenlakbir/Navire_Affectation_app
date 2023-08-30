package org.sid.navire_app_backend.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Grue {
    @Id
    private String matricule_grue;
    private String Taille_Grue;
    private String Nom_grue;
    @OneToMany(mappedBy = "grue")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Affectation> affectations;
}
