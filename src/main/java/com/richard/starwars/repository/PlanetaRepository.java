package com.richard.starwars.repository;

import java.util.List;

import com.richard.starwars.models.Planetas;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlanetaRepository extends MongoRepository<Planetas, String> {
    
    //função responsavel pela pesquis por nome dos planetas
    List<Planetas> findByNomeContainingIgnoreCase(String nome);

}