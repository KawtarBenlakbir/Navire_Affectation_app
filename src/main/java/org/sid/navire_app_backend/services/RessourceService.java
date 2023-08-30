package org.sid.navire_app_backend.services;

import org.sid.navire_app_backend.dtos.*;
import org.sid.navire_app_backend.exceptions.*;

import java.sql.Date;
import java.util.List;

public interface RessourceService {
    NavireDTO saveNavire(NavireDTO navireDTO);
    EquipeDTO saveEquipe(EquipeDTO equipeDTO);
    EnginDTO saveEngin(EnginDTO enginDTO);
    GrueDTO saveGrue(GrueDTO grueDTO);
    AffectationDTO saveAffectation(AffectationDTO affectationDTO);
    List<NavireDTO> listNavire();
    List<GrueDTO> listGrue();
    List<EquipeDTO> listEquipe();
    List<EnginDTO> listEngin();
    List<AffectationDTO> listAffectation();

    NavireDTO getNavire(String id_Navire)throws NavireNotFoundException;
    NavireDTO updateNavire(NavireDTO navireDTO);
    void deleteNavire(String id_Navire);
    EnginDTO getEngin(String matricule_Engin)throws EnginNotFoundException;
    EnginDTO updateEngin(EnginDTO enginDTO);
    void deleteEngin(String matricule_Engin);
    EquipeDTO getEquipe(String matricule_Equipe)throws EquipeNotFoundException;
    EquipeDTO updateEquipe(EquipeDTO equipeDTO);
    void deleteEquipe(String matricule_Equipe);
    GrueDTO getGrue(String matricule_Grue)throws GrueNotFoundException;
    GrueDTO updateGrue(GrueDTO grueDTO);
    void deleteGrue(String matricule_Grue);

    AffectationDTO getAffectation(int id_Affectation) throws AffectationNotFoundException, GrueNotFoundException;
    AffectationDTO updateAffectation(AffectationDTO affectationDTO);
    void deleteAffectation(int id_Affectation);


     List<NavireDTO> searchNavires(String keyword);
    List<EquipeDTO> searchEquipes(String id_String);
    List<EnginDTO> searchEngins(String id_String);
    List<GrueDTO> searchGrues(String id_String);
    List<AffectationDTO> searchAffectations(String keyword);
}
