package org.sid.navire_app_backend.repositories;

import org.sid.navire_app_backend.entities.Grue;
import org.sid.navire_app_backend.entities.Navire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface NavireRepositories extends JpaRepository<Navire,String> {

    @Query("select n from Navire n where n.Date_arrivee like :kw")
    List<Navire> searchNavire(@Param("kw") String keyword);



}
