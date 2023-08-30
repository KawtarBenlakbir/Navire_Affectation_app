package org.sid.navire_app_backend.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sid.navire_app_backend.dtos.AffectationDTO;
import org.sid.navire_app_backend.dtos.NavireDTO;
import org.sid.navire_app_backend.exceptions.*;
import org.sid.navire_app_backend.services.RessourceService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class AffectationController {
    private RessourceService ressourceService;
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    @GetMapping("/Affectations")
    public List<AffectationDTO> Affectations(){
        return ressourceService.listAffectation();
    }
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    @GetMapping("/Affectations/{id}")
    public AffectationDTO getAffectation(@PathVariable(name = "id") int AffectationId) throws AffectationNotFoundException, GrueNotFoundException {
        return ressourceService.getAffectation(AffectationId);
    }
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @PostMapping("/Affectations")
    public AffectationDTO saveAffectation(@RequestBody AffectationDTO affectationDTO) {
        AffectationDTO savedAffectation = ressourceService.saveAffectation(affectationDTO);
        return savedAffectation;
    }


    @GetMapping("/Affectations/search")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public List<AffectationDTO> searchAffectations(@RequestParam(name = "keyword",defaultValue = "") String keyword){
        return  ressourceService.searchAffectations("%"+keyword+"%");
    }
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
        @PutMapping("/Affectations/{AffectationId}")
    public AffectationDTO updateAffectation(@PathVariable int AffectationId, @RequestBody AffectationDTO AffectationDTO){
        AffectationDTO.setId_Affectation(AffectationId);
        return ressourceService.updateAffectation(AffectationDTO);
    }
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @DeleteMapping("/Affectations/{id}")
    public void deleteAffectation(@PathVariable int id){
        ressourceService.deleteAffectation(id);
    }

}
