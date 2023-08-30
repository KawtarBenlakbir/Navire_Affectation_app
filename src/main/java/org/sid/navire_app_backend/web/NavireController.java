package org.sid.navire_app_backend.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sid.navire_app_backend.dtos.GrueDTO;
import org.sid.navire_app_backend.dtos.NavireDTO;
import org.sid.navire_app_backend.entities.Navire;
import org.sid.navire_app_backend.exceptions.NavireNotFoundException;
import org.sid.navire_app_backend.services.RessourceService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class NavireController {
    private RessourceService ressourceService;
    @GetMapping("/Navires")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public List<NavireDTO> navires(){
        return ressourceService.listNavire();
    }
    @GetMapping("/Navires/search")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public List<NavireDTO> searchNavires(@RequestParam(name = "keyword",defaultValue = "") String keyword){
        return  ressourceService.searchNavires("%"+keyword+"%");
    }
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @GetMapping("/Navires/{id}")
    public NavireDTO getNavire(@PathVariable(name = "id") String NavireId) throws NavireNotFoundException {
        return ressourceService.getNavire(NavireId);
    }
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @PostMapping("/Navires")
    public NavireDTO saveNavire(@RequestBody NavireDTO navireDTO){
        return ressourceService.saveNavire(navireDTO);
    }
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @PutMapping("/Navires/{NavireId}")
    public NavireDTO updateNavire(@PathVariable String NavireId, @RequestBody NavireDTO NavireDTO){
        NavireDTO.setId_Navire(NavireId);
        return ressourceService.updateNavire(NavireDTO);
    }
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @DeleteMapping("/Navires/{id}")
    public void deleteNavire(@PathVariable String id){
        ressourceService.deleteNavire(id);
    }
}

