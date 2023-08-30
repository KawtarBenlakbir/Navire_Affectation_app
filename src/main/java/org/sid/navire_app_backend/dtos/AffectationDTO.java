package org.sid.navire_app_backend.dtos;

import lombok.Data;

@Data
public class AffectationDTO {
    private int id_Affectation;
    private String Navire_id ;
    private String engin_id;
    private String equipe_id;
    private String grue_id;
}
