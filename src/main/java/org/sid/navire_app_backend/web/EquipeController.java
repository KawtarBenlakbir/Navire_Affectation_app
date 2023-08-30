package org.sid.navire_app_backend.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sid.navire_app_backend.dtos.EquipeDTO;
import org.sid.navire_app_backend.dtos.NavireDTO;
import org.sid.navire_app_backend.exceptions.EquipeNotFoundException;
import org.sid.navire_app_backend.services.RessourceService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class EquipeController {

    private RessourceService ressourceService;
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @GetMapping("/Equipes")
    public List<EquipeDTO> Equipes(){
        return ressourceService.listEquipe();
    }
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @GetMapping("/Equipes/{id}")
    public EquipeDTO getEquipe(@PathVariable(name = "id") String EquipeId) throws EquipeNotFoundException {
        return ressourceService.getEquipe(EquipeId);
    }
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @GetMapping("/Equipes/search")
    public List<EquipeDTO> searchEquipes(@RequestParam(name = "id_String",defaultValue = "")String id_String){
        return  ressourceService.searchEquipes("%"+id_String+"%");
    }
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @PostMapping("/Equipes")
    public EquipeDTO saveEquipe(@RequestBody EquipeDTO EquipeDTO){
        return ressourceService.saveEquipe(EquipeDTO);
    }
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @PutMapping("/Equipes/{EquipeId}")
    public EquipeDTO updateEquipe(@PathVariable String EquipeId, @RequestBody EquipeDTO EquipeDTO){
        EquipeDTO.setMatricule_Equipe(EquipeId);
        return ressourceService.updateEquipe(EquipeDTO);
    }
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @DeleteMapping("/Equipes/{id}")
    public void deleteEquipe(@PathVariable String id){
        ressourceService.deleteEquipe(id);
    }

}
