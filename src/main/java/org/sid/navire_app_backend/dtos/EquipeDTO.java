package org.sid.navire_app_backend.dtos;

import lombok.Data;
import org.sid.navire_app_backend.entities.Navire;
@Data
public class EquipeDTO {
    private String matricule_Equipe;
    private int Nombre_Membre;
}
