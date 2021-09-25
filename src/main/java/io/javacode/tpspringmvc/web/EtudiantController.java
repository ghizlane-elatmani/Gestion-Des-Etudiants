package io.javacode.tpspringmvc.web;

import io.javacode.tpspringmvc.dao.EtudiantRepository;
import io.javacode.tpspringmvc.entities.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/etudiant")
public class EtudiantController {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @RequestMapping(value = "/index")
    public String Index(Model model,
                        @RequestParam(name = "page", defaultValue = "0")int page,
                        @RequestParam(name = "motCle", defaultValue = "")String mc){

        Page<Etudiant> etudiantPage = etudiantRepository.chercherEtudiants("%"+mc+"%", PageRequest.of(page, 5));

        int pagesCount = etudiantPage.getTotalPages();
        int[] pages = new int[pagesCount];
        for(int i=0; i<pagesCount; i++)
            pages[i] = i;

        model.addAttribute("pages", pages);
        model.addAttribute("pageEtudiants", etudiantPage);
        model.addAttribute("pageCourante", page);
        model.addAttribute("motCle", mc);
        return "etudiants";
    }

}
