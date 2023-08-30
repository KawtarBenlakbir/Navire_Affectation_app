package org.sid.navire_app_backend.repositories;

import org.sid.navire_app_backend.entities.Affectation;
import org.sid.navire_app_backend.entities.Engin;
import org.sid.navire_app_backend.entities.Navire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AffectationRepositories extends JpaRepository<Affectation,Integer> {
    @Query("select a from Affectation a where a.navire.id_Navire like :kw")
    List<Affectation> searchAffectation(@Param("kw") String keyword);

}
