package org.sid.navire_app_backend.repositories;

import org.sid.navire_app_backend.entities.Grue;
import org.sid.navire_app_backend.entities.Navire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GrueRepositories extends JpaRepository<Grue,String> {
    @Query("select g from Grue g where g.matricule_grue like :kw")
    List<Grue> searchGrue(@Param("kw") String keyword);
}
