package org.sid.navire_app_backend.mappers;

import org.sid.navire_app_backend.dtos.*;
import org.sid.navire_app_backend.entities.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class AffectationMapper {
    public NavireDTO fromNavire(Navire navire){
        NavireDTO navireDTO = new NavireDTO();
        BeanUtils.copyProperties(navire,navireDTO);
        return navireDTO;
    }
    public Navire fromNavireDTO(NavireDTO navireDTO){
        Navire navire =new Navire();
        BeanUtils.copyProperties(navireDTO,navire);
        return navire;
    }
    public EnginDTO fromEngin(Engin engin){
        EnginDTO enginDTO=new EnginDTO();
        BeanUtils.copyProperties(engin,enginDTO);
        return enginDTO;
    }
    public Engin fromEnginDTO(EnginDTO enginDTO){
        Engin engin=new Engin();
        BeanUtils.copyProperties(enginDTO,engin);
        return engin;
    }

    public EquipeDTO fromEquipe(Equipe equipe){
        EquipeDTO equipeDTO=new EquipeDTO();
        BeanUtils.copyProperties(equipe,equipeDTO);
        return equipeDTO;
    }
    public Equipe fromEquipeDTO(EquipeDTO equipeDTO){
        Equipe equipe=new Equipe();
        BeanUtils.copyProperties(equipeDTO,equipe);
        return equipe;
    }
    public GrueDTO fromGrue(Grue grue){
        GrueDTO grueDTO=new GrueDTO();
        BeanUtils.copyProperties(grue,grueDTO);
        return grueDTO;
    }
    public Grue fromGrueDTO(GrueDTO grueDTO){
        Grue grue=new Grue();
        BeanUtils.copyProperties(grueDTO,grue);
        return grue;
    }
    public AffectationDTO fromAffectation(Affectation affectation){
        AffectationDTO affectationDTO = new AffectationDTO();
        affectationDTO.setId_Affectation(affectation.getId_Affectation());
        affectationDTO.setNavire_id(affectation.getNavire().getId_Navire());
        affectationDTO.setEngin_id(affectation.getEngin().getMatricule_engin());
        affectationDTO.setEquipe_id(affectation.getEquipe().getMatricule_Equipe());
        affectationDTO.setGrue_id(affectation.getGrue().getMatricule_grue());
        return affectationDTO;
    }
    public Affectation fromAffectationDTO(AffectationDTO affectationDTO){
        Affectation affectation = new Affectation();
        Navire navire = new Navire();
        navire.setId_Navire(affectationDTO.getNavire_id());
        affectation.setNavire(navire);

        Engin engin = new Engin();
        engin.setMatricule_engin(affectationDTO.getEngin_id());
        affectation.setEngin(engin);

        Equipe equipe = new Equipe();
        equipe.setMatricule_Equipe(affectationDTO.getEquipe_id());
        affectation.setEquipe(equipe);
        Grue grue = new Grue();
        grue.setMatricule_grue(affectationDTO.getGrue_id());
        affectation.setGrue(grue);

        return affectation;
    }

}
