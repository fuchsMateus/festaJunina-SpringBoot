package com.mateusfuchs.festajuninasb.services;

import com.mateusfuchs.festajuninasb.entities.Salgado;
import com.mateusfuchs.festajuninasb.repositories.SalgadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalgadoService {

    SalgadoRepository repo;

    @Autowired
    public SalgadoService(SalgadoRepository repo){
        this.repo = repo;
    }

    public Salgado findById(Integer id){
        Optional<Salgado> salgadoOptional = repo.findById(id);
        return salgadoOptional.orElse(null);
    }

    public List<Salgado> findAll(){
        return repo.findAll(Sort.by(Sort.Direction.ASC, "tipo"));
    }

    public Salgado save(Salgado salgado){
        repo.save(salgado);
        return salgado;
    }

    public Salgado delete(Salgado salgado){
        repo.delete(salgado);
        return salgado;
    }

    public Salgado deleteById(Integer id){
        Salgado salgado = findById(id);
        delete(salgado);
        return salgado;
    }
}
