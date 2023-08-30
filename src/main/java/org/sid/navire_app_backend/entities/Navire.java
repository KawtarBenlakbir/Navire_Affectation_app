package org.sid.navire_app_backend.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import javax.swing.*;
import java.sql.Time;
import java.time.DateTimeException;
import java.util.Date;
import java.util.List;
import java.util.Timer;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Navire {
    @Id
    private String id_Navire;
    private String Nom_Navire;
    private String Taille_Navire;
    private String Date_arrivee;
    @OneToMany(mappedBy = "navire")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Affectation> affectations;

}
