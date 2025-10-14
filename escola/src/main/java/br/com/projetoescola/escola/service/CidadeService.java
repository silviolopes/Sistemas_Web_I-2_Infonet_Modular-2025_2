package br.com.projetoescola.escola.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoescola.escola.entity.Cidade;
import br.com.projetoescola.escola.repository.CidadeRepository;

@Service
public class CidadeService {


    @Autowired
    private CidadeRepository cidadeRepository;

  
    public Cidade save(Cidade cidade){
        return cidadeRepository.save(cidade);
    }

    public List<Cidade> findAll(){
        return cidadeRepository.findAll();
    }

    public void deleteById(Integer id){
        cidadeRepository.deleteById(id);
    }

    public Cidade findById(Integer id){
        return cidadeRepository.findById(id).orElse(null);
    }
    
    
}
