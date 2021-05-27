package tableaux.controller;

import galerie.dao.TableauRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author alwen
 */

@Controller
@RequestMapping(path = "/tableau")
public class TableauxController {
    
    @Autowired
    private TableauRepository dao;
     
     
    @GetMapping(path = "show")
    public String afficheTousLesTableaux(Model model) {
        model.addAttribute("tableaux", dao.findAll());
        return "afficheTableaux";
    }
}
