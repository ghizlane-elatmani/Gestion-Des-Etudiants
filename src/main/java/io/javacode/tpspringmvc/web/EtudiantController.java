package io.javacode.tpspringmvc.web;

import io.javacode.tpspringmvc.dao.EtudiantRepository;
import io.javacode.tpspringmvc.entities.Etudiant;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String formEtudiant(Model model){
        model.addAttribute("etudiant", new Etudiant());
        return "formEtudiant";
    }

    @RequestMapping(value = "/saveEtudiant", method = RequestMethod.POST)
    public String save(@Valid Etudiant etudiant,
                       BindingResult bindingResult,
                       @RequestParam(name="picture") MultipartFile file) throws IOException {
        if(bindingResult.hasErrors()){
            return "formEtudiant";
        }

        if(!file.isEmpty()){
            etudiant.setPhoto(file.getOriginalFilename());
        }

        etudiantRepository.save(etudiant);

        if(!file.isEmpty()){
            etudiant.setPhoto(file.getOriginalFilename());
            file.transferTo(new File("/home/riri/sco/" + etudiant.getId()));
        }

        return "redirect:index";
    }

    @RequestMapping(value = "/getPhoto", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getPhoto(Long id) throws Exception {
        File f = new File("/home/riri/sco/"+id);
        return IOUtils.toByteArray(new FileInputStream(f));

    }

    @RequestMapping(value = "/supprimer")
    public String supprimer(Long id){
        etudiantRepository.deleteById(id);
        return "redirect:index";
    }


}
