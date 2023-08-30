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
public class Engin  {
    @Id
    private String matricule_engin;
    private String Taille_Engin;
    private int capacite_engin;
    @OneToMany(mappedBy = "engin")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Affectation> affectations;
}
