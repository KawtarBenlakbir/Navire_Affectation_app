package org.sid.navire_app_backend;

import jakarta.persistence.GeneratedValue;
import org.sid.navire_app_backend.dtos.AffectationDTO;
import org.sid.navire_app_backend.entities.*;
import org.sid.navire_app_backend.repositories.*;
import org.sid.navire_app_backend.services.RessourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import static org.apache.commons.lang3.RandomUtils.nextInt;

@SpringBootApplication
public class NavireAppBackendApplication {
    @Autowired
    NavireRepositories navireRepositories;
    @Autowired
    EnginRepositories enginRepositories;
    @Autowired
    EquipeRepositories equipeRepositories;
    @Autowired
    GrueRepositories grueRepositories;
    @Autowired
    AffectationRepositories affectationRepositories;

    public static void main(String[] args) {
        SpringApplication.run(NavireAppBackendApplication.class, args);
    }

    @Bean
    public void enregistrerNavires() {

        for (int i =1;i<=10 ; i++) {

            Navire n = new Navire();
            n.setId_Navire("MLt663"+i);
            n.setNom_Navire("Navire"+i);
            n.setTaille_Navire("Moyenne");
            n.setDate_arrivee("2020-12-11 20:23:55");
            navireRepositories.save(n);

        }
        for (int i =1;i<=10 ; i++) {
            Engin e = new Engin();
            e.setMatricule_engin("EN9253"+i);
            e.setCapacite_engin(23+i);
            e.setTaille_Engin("3m-1m");
            enginRepositories.save(e);
        }
        for (int i =1;i<=10 ; i++) {
            Equipe e = new Equipe();
            e.setMatricule_Equipe("EQ9253"+i);
            e.setNombre_Membre(3+i);
            equipeRepositories.save(e);
        }
        for (int i =1;i<=10 ; i++) {
            Grue e = new Grue();
            e.setMatricule_grue("GR9253"+i);
            e.setNom_grue("Grue"+i);
            e.setTaille_Grue("30m-10m");
            grueRepositories.save(e);
        }

    }
}
