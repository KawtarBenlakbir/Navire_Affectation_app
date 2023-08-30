package org.sid.navire_app_backend.repositories;

import org.sid.navire_app_backend.entities.Engin;
import org.sid.navire_app_backend.entities.Navire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EnginRepositories extends JpaRepository<Engin,String> {
    @Query("select e from Engin e where e.matricule_engin like :kw")
    List<Engin> searchEngin(@Param("kw") String keyword);
}
