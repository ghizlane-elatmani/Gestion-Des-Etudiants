package io.javacode.tpspringmvc.web;

import io.javacode.tpspringmvc.dao.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EtudiantController {

    @Autowired
    private EtudiantRepository etudiantRepository;

}
