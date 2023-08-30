package org.sid.navire_app_backend.dtos;

import lombok.Data;

import javax.swing.*;
import java.sql.Time;
import java.time.DateTimeException;
import java.util.Date;

@Data
public class NavireDTO {
    private String id_Navire;
    private String Nom_Navire;
    private String Taille_Navire;
    private String Date_arrivee;
}
