package org.sid.navire_app_backend.dtos;

import lombok.Data;
import org.sid.navire_app_backend.entities.Navire;

@Data
public class EnginDTO {
    private String matricule_engin;
    private String Taille_Engin;
    private int capacite_engin;

}
