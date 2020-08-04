package com.richard.starwars.service;

import java.util.List;
import java.util.Optional;

import com.richard.starwars.models.Planetas;
import com.richard.starwars.repository.PlanetaRepository;
import com.richard.starwars.service.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanetaService {

    @Autowired
    private PlanetaRepository repo;
    
    //Pesquia por todos os planetas
    public List<Planetas> findALL(){
        return repo.findAll();
    }

    //Pesquisa determinado planeta pelo id informado
    public Planetas findiById(String id){
        Optional<Planetas> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    //Cadastra um novo Planeta
    public Planetas insert(Planetas obj){
        return repo.insert(obj);
    }

    //Deleta Determinado planeta baseado no id informado
    public void delete(String id){
        findiById(id);
        repo.deleteById(id);
    }

    //Retorna os planetas com o nome da pesquisa na variavel nome
    public List<Planetas> findByName(String nome){
        return repo.findByNomeContainingIgnoreCase(nome);
    }



}