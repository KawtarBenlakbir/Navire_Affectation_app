package org.sid.navire_app_backend.repositories;

import org.sid.navire_app_backend.entities.Equipe;
import org.sid.navire_app_backend.entities.Navire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EquipeRepositories extends JpaRepository<Equipe,String> {
    @Query("select e from Equipe e where e.matricule_Equipe like :kw")
    List<Equipe> searchEquipe(@Param("kw") String keyword);
}
