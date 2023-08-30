package org.sid.navire_app_backend.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sid.navire_app_backend.dtos.GrueDTO;
import org.sid.navire_app_backend.dtos.NavireDTO;
import org.sid.navire_app_backend.exceptions.GrueNotFoundException;
import org.sid.navire_app_backend.services.RessourceService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class GrueController {
  private RessourceService ressourceService;
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @GetMapping("/Grues")
    public List<GrueDTO> grues(){
        return ressourceService.listGrue();
    }
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @GetMapping("/Grues/{id}")
    public GrueDTO getGrue(@PathVariable(name = "id") String GrueId) throws GrueNotFoundException {
        return ressourceService.getGrue(GrueId);
    }
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @GetMapping("/Grues/search")
    public List<GrueDTO> searchGrues(@RequestParam(name = "id_String",defaultValue = "")String id_String){
        return  ressourceService.searchGrues("%"+id_String+"%");
    }
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @PostMapping("/Grues")
    public GrueDTO saveGrue(@RequestBody GrueDTO GrueDTO){
        return ressourceService.saveGrue(GrueDTO);
    }
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @PutMapping("/Grues/{GrueId}")
    public GrueDTO updateGrue(@PathVariable String GrueId, @RequestBody GrueDTO GrueDTO){
        GrueDTO.setMatricule_grue(GrueId);
        return ressourceService.updateGrue(GrueDTO);
    }
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @DeleteMapping("/Grues/{id}")
    public void deleteGrue(@PathVariable String id){
        ressourceService.deleteGrue(id);
    }
}
