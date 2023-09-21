package com.mateusfuchs.festajuninasb.controllers;

import com.mateusfuchs.festajuninasb.entities.Salgado;
import com.mateusfuchs.festajuninasb.services.SalgadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class SalgadoController {

    SalgadoService service;

    @Autowired
    public SalgadoController(SalgadoService service){
        this.service = service;
    }

    @GetMapping("/")
    public ModelAndView salgadosView(){
        ModelAndView mvn = new ModelAndView("salgados");
        mvn.addObject("salgados", service.findAll());
        return mvn;
    }
    @PostMapping("/cadastro")
    public ModelAndView cadastrar(@RequestBody Salgado salgado){
        for (Salgado s : service.findAll()) {
            if(s.getTipo().equals(salgado.getTipo()) && s.getSabor().equals(salgado.getSabor()) && s.getFritoOuAssado().equals(salgado.getFritoOuAssado()))
                salgado.setId(s.getId());
        }
        service.save(salgado);
        return salgadosView();
    }

    @DeleteMapping("/deletar")
    public ModelAndView cadastrar(@RequestBody Integer id){

        Salgado salgado = service.findById(id);
        if (salgado == null)
            throw new NullPointerException();
        service.delete(salgado);
        return salgadosView();
    }


}
