package io.javacode.tpspringmvc.web;

import io.javacode.tpspringmvc.dao.EtudiantRepository;
import io.javacode.tpspringmvc.entities.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/etudiant")
public class EtudiantController {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @RequestMapping(value = "/index")
    public  String Index(){
        List<Etudiant> etudiantList = etudiantRepository.findAll();
        return "etudiants";
    }

}
