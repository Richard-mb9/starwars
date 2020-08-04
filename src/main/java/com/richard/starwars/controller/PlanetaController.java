package com.richard.starwars.controller;

import java.net.URI;

import java.util.List;
import java.util.stream.Collectors;


import com.richard.starwars.controller.util.URL;
import com.richard.starwars.dto.PlanetasDTO;
import com.richard.starwars.models.Planetas;
import com.richard.starwars.service.PlanetaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/planetas")
public class PlanetaController {
    @Autowired
    private PlanetaService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<PlanetasDTO>> findAll(){
        //Pega uma Lista com todos os Planetas Cadastrados
        List<Planetas> lista = service.findALL();

        /**PlanetasDTO confere se o planeta apareceu em algum filme
         * caso tenha aparecido ele adiciona os filmes que ele apareceu em
         * uma variavel chama filmes 
         */
        List<PlanetasDTO> listaDTO = lista.stream().map(x -> new PlanetasDTO(x)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listaDTO);
    }


    /** A função abaixo filtra os planetas por id
     * PlanetasDTO confere se o planeta apareceu em algum filme
     * caso tenha aparecido ele adiciona os filmes que ele apareceu em
     * uma variavel chama filmes 
     */
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<PlanetasDTO> findById(@PathVariable String id) {
        //primeiro a função busca nos serviços se existe algum planeta com o id informado
        Planetas obj = service.findiById(id);

        return ResponseEntity.ok().body(new PlanetasDTO(obj));
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Planetas planeta) {
        service.insert(planeta);


        //O codigo abaixo retorna uma resposta ao cliente indicando que os dados foram salvos
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(planeta.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    //função que deleta o planeta, deve ser informado id
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id) {
        
        service.delete(id);

        return ResponseEntity.noContent().build();
    }


    /**função que efetua a pesquisa dos planetas por nome
     * deve ser informada a rota planetas/search?nome + no nome do planeta a ser consultado 
     */
    @RequestMapping(value="/search", method=RequestMethod.GET)
    public ResponseEntity<List< PlanetasDTO>> findByNome(@RequestParam(value = "nome",
    defaultValue = "") String nome) {
        
        //Cria uma Lista com todos os planetas com o nome que esta sendo pesquisado
        List<Planetas> lista = service.findByName(nome);

        nome = URL.decodeParam(nome);

        //caso algum o planeta tenha aparecido em algum filme Planetas DTO adiciona os filmes que em que apareceram
        List<PlanetasDTO> listaDTO = lista.stream().
            map(x -> new PlanetasDTO(x)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listaDTO);
    }
    


    
}