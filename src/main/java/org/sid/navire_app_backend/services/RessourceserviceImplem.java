package org.sid.navire_app_backend.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sid.navire_app_backend.dtos.*;
import org.sid.navire_app_backend.entities.*;
import org.sid.navire_app_backend.exceptions.*;
import org.sid.navire_app_backend.mappers.AffectationMapper;
import org.sid.navire_app_backend.repositories.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class RessourceserviceImplem implements RessourceService{
    private NavireRepositories navireRepositories;
    private EquipeRepositories equipeRepositories;
    private EnginRepositories enginRepositories;
    private GrueRepositories grueRepositories;
    private AffectationRepositories affectationRepositories;
    private AffectationMapper affectationMapper;
    @Override
    public NavireDTO saveNavire(NavireDTO navireDTO) {
        log.info("Saving new Navire");
        Navire navire =affectationMapper.fromNavireDTO(navireDTO);
        Navire savedNavire = navireRepositories.save(navire);
        return affectationMapper.fromNavire(savedNavire);
    }

    @Override
    public EquipeDTO saveEquipe(EquipeDTO equipeDTO)  {
        log.info("Saving new Equipe");
        Equipe equipe=affectationMapper.fromEquipeDTO(equipeDTO);
        Equipe savedEquipe = equipeRepositories.save(equipe);
        return affectationMapper.fromEquipe(savedEquipe);
    }

    @Override
    public EnginDTO saveEngin(EnginDTO enginDTO)  {
        log.info("Saving new Engin");
        Engin engin =affectationMapper.fromEnginDTO(enginDTO);
        Engin savedengin = enginRepositories.save(engin);
        return affectationMapper.fromEngin(savedengin);
    }

    @Override
    public GrueDTO saveGrue(GrueDTO grueDTO)  {
        log.info("Saving new Grue");
        Grue grue=affectationMapper.fromGrueDTO(grueDTO);
        Grue savedGrue= grueRepositories.save(grue);
        return affectationMapper.fromGrue(savedGrue);
    }

    @Override
    public AffectationDTO saveAffectation( AffectationDTO affectationDTO) {
        log.info("Saving new Grue");
        Affectation affectation=affectationMapper.fromAffectationDTO(affectationDTO);
        Affectation savedAffectation= affectationRepositories.save(affectation);
        return affectationMapper.fromAffectation(savedAffectation);

    }



    @Override
    public List<NavireDTO> listNavire() {
        List<Navire>navires = navireRepositories.findAll();
        List<NavireDTO> navireDTOS = navires.stream().map(navire -> affectationMapper.fromNavire(navire)).collect(Collectors.toList());
        return navireDTOS;
    }

    @Override
    public List<GrueDTO> listGrue() {
        List<Grue>grues= grueRepositories.findAll();
        List<GrueDTO> grueDTOS = grues.stream().map(grue -> affectationMapper.fromGrue(grue)).collect(Collectors.toList());
        return grueDTOS;
    }
    public List<EquipeDTO> listEquipe() {
        List<Equipe>equipes= equipeRepositories.findAll();
        List<EquipeDTO> equipeDTOS = equipes.stream().map(equipe-> affectationMapper.fromEquipe(equipe)).collect(Collectors.toList());
        return equipeDTOS;
    }

    @Override
    public List<EnginDTO> listEngin() {
        List<Engin>engins= enginRepositories.findAll();
        List<EnginDTO> enginDTOS = engins.stream().map(engin-> affectationMapper.fromEngin(engin)).collect(Collectors.toList());
        return enginDTOS;
    }

    @Override
    public List<AffectationDTO> listAffectation() {
        List<Affectation>affectations = affectationRepositories.findAll();
        List<AffectationDTO> affectationDTOS = affectations.stream().map(affectation-> affectationMapper.fromAffectation(affectation)).collect(Collectors.toList());
        return affectationDTOS;
    }

    @Override
    public NavireDTO getNavire(String id_Navire) throws NavireNotFoundException {
        Navire navire = navireRepositories.findById(id_Navire).orElseThrow(()->
                new NavireNotFoundException(" Navire not found "));
        return affectationMapper.fromNavire(navire);
    }

    @Override
    public NavireDTO updateNavire(NavireDTO navireDTO) {
        log.info(" saving new navire");
        Navire navire= affectationMapper.fromNavireDTO(navireDTO);
        Navire savedNavire= navireRepositories.save(navire);
        return affectationMapper.fromNavire(savedNavire);
    }

    @Override
    public void deleteNavire(String id_Navire) {
        navireRepositories.deleteById(id_Navire);
    }

    @Override
    public EnginDTO getEngin(String matricule_Engin) throws EnginNotFoundException {
        Engin engin = enginRepositories.findById(matricule_Engin).orElseThrow(()->
                new EnginNotFoundException(" Engin not found "));
        return affectationMapper.fromEngin(engin);
    }

    @Override
    public EnginDTO updateEngin(EnginDTO enginDTO) {
        log.info(" saving new Engin");
        Engin engin = affectationMapper.fromEnginDTO(enginDTO);
        Engin savedEngin= enginRepositories.save(engin);
        return affectationMapper.fromEngin(savedEngin);
    }

    @Override
    public void deleteEngin(String matricule_Engin) {
        enginRepositories.deleteById(matricule_Engin);
    }

    @Override
    public EquipeDTO getEquipe(String matricule_Equipe)throws EquipeNotFoundException {
        Equipe equipe = equipeRepositories.findById(matricule_Equipe).orElseThrow(()->
                new EquipeNotFoundException(" Engin not found "));
        return affectationMapper.fromEquipe(equipe);
    }

    @Override
    public EquipeDTO updateEquipe(EquipeDTO equipeDTO) {
        log.info(" saving new Equipe");
        Equipe equipe = affectationMapper.fromEquipeDTO(equipeDTO);
        Equipe savedEquipe= equipeRepositories.save(equipe);
        return affectationMapper.fromEquipe(savedEquipe);
    }

    @Override
    public void deleteEquipe(String matricule_Equipe) {
        equipeRepositories.deleteById(matricule_Equipe);
    }

    @Override
    public GrueDTO getGrue(String matricule_Grue) throws GrueNotFoundException {
        Grue grue = grueRepositories.findById(matricule_Grue).orElseThrow(()->
                new GrueNotFoundException(" Grue not found "));
        return affectationMapper.fromGrue(grue);
    }

    @Override
    public GrueDTO updateGrue(GrueDTO grueDTO) {
        log.info(" saving new Grue");
        Grue grue = affectationMapper.fromGrueDTO(grueDTO);
        Grue savedGrue= grueRepositories.save(grue);
        return affectationMapper.fromGrue(savedGrue);
    }

    @Override
    public void deleteGrue(String matricule_Grue) {
        grueRepositories.deleteById(matricule_Grue);
    }

    @Override
    public AffectationDTO getAffectation(int id_Affectation) throws AffectationNotFoundException {
        Affectation affectation = affectationRepositories.findById(id_Affectation).orElseThrow(()->
                new AffectationNotFoundException(" Affectation not found "));
        return affectationMapper.fromAffectation(affectation);
    }

    @Override
    public AffectationDTO updateAffectation(AffectationDTO affectationDTO) {
        log.info(" saving new Grue");
        Affectation affectation = affectationMapper.fromAffectationDTO(affectationDTO);
        Affectation savedAffectation= affectationRepositories.save(affectation);
        return affectationMapper.fromAffectation(savedAffectation);
    }

    @Override
    public void deleteAffectation(int id_Affectation) {
        affectationRepositories.deleteById(id_Affectation);
    }

    @Override
    public List<NavireDTO> searchNavires(String keyword) {
        List<Navire> Navires= navireRepositories.searchNavire(keyword);
        List<NavireDTO> NavireDTOS = Navires.stream().map(navire -> affectationMapper.fromNavire(navire)).collect(Collectors.toList());
        return NavireDTOS;
    }


    @Override
    public List<EquipeDTO> searchEquipes(String id_String) {
        List<Equipe> Equipes= equipeRepositories.searchEquipe(id_String);
        List<EquipeDTO> EquipeDTOS = Equipes.stream().map(equipe -> affectationMapper.fromEquipe(equipe)).collect(Collectors.toList());
        return EquipeDTOS;
    }

    @Override
    public List<EnginDTO> searchEngins(String id_String) {
        List<Engin> Engins= enginRepositories.searchEngin(id_String);
        List<EnginDTO> EnginDTOS = Engins.stream().map(engin -> affectationMapper.fromEngin(engin)).collect(Collectors.toList());
        return EnginDTOS;
    }

    @Override
    public List<GrueDTO> searchGrues(String id_String) {
        List<Grue> Grues= grueRepositories.searchGrue(id_String);
        List<GrueDTO> GrueDTOS = Grues.stream().map(grue -> affectationMapper.fromGrue(grue)).collect(Collectors.toList());
        return GrueDTOS;
    }
    @Override
    public List<AffectationDTO> searchAffectations(String keyword) {
        List<Affectation> Affectations= affectationRepositories.searchAffectation(keyword);
        List<AffectationDTO> AffectationDTOS = Affectations.stream().map(Affectation -> affectationMapper.fromAffectation(Affectation)).collect(Collectors.toList());
        return AffectationDTOS;
    }
}
