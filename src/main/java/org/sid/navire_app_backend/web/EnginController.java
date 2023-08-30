package org.sid.navire_app_backend.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sid.navire_app_backend.dtos.EnginDTO;
import org.sid.navire_app_backend.dtos.EquipeDTO;
import org.sid.navire_app_backend.dtos.GrueDTO;
import org.sid.navire_app_backend.exceptions.EnginNotFoundException;
import org.sid.navire_app_backend.exceptions.EquipeNotFoundException;
import org.sid.navire_app_backend.services.RessourceService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class EnginController {
    private RessourceService ressourceService;
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @GetMapping("/Engins")
    public List<EnginDTO> Engins(){
        return ressourceService.listEngin();
    }
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @GetMapping("/Engins/{id}")
    public EnginDTO getEngin(@PathVariable(name = "id") String EnginId) throws EnginNotFoundException {
        return ressourceService.getEngin(EnginId);
    }
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @GetMapping("/Engins/search")
    public List<EnginDTO> searchEngins(@RequestParam(name = "id_String",defaultValue = "")String id_String){
        return  ressourceService.searchEngins("%"+id_String+"%");
    }
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @PostMapping("/Engins")
    public EnginDTO saveEngin(@RequestBody EnginDTO EnginDTO){
        return ressourceService.saveEngin(EnginDTO);
    }
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @PutMapping("/Engins/{EnginId}")
    public EnginDTO updateEngin(@PathVariable String EnginId, @RequestBody EnginDTO EnginDTO){
        EnginDTO.setMatricule_engin(EnginId);
        return ressourceService.updateEngin(EnginDTO);
    }
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @DeleteMapping("/Engins/{id}")
    public void deleteEngin(@PathVariable String id){
        ressourceService.deleteEngin(id);
    }

}
