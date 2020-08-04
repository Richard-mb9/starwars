package com.richard.starwars.dto;

import java.io.Serializable;

import java.util.ArrayList;

import com.richard.starwars.models.Planetas;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;




public class PlanetasDTO implements Serializable{
    private static final long serialVersionUID = 1L;


    private String id;
    private String nome;
    private String clima;
    private String terreno;
    private ArrayList<String> filmes = new ArrayList<String>();


    public PlanetasDTO(){

    }
    public PlanetasDTO(Planetas planeta){
        id = planeta.getId();
        nome = planeta.getNome();
        clima = planeta.getClima();
        terreno = planeta.getTerreno();

        RestTemplate restTemplate = new RestTemplate();

        //Faz a conexão com a API e procura se ha algum planeta com o nome cadastrado
        String p = restTemplate.getForObject("https://swapi.dev/api/planets/?search=" + nome, String.class);
        JSONObject obj = new JSONObject(p);
        JSONArray results = obj.getJSONArray("results");

        try{
            /**Caso Seja encontrado mais de um planeta com nome igual o nome cadastrado os filmes
             * em que ele apareceu tambem serão adicionados a variavel filmes
             */
            for(Integer i = 0; i < results.length(); i++ ){
                JSONObject pl = results.getJSONObject(i);
                JSONArray f = pl.getJSONArray("films");
                /**O codigo abaixo pega um dos planetas encontrados e confere se ele apareceu em algum filme
                 *Caso ele tenha aparecido, o filme sera adicionado a variavel filmes
                 */
                for(Integer y = 0; y < f.length(); y++ ){
                    String fil = f.get(y).toString();
                    fil = getF(fil);
                    this.filmes.add(fil);
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }


    //Função que recebe as urls referentes a cada filme, retorna com o nome dele
    private String getF(String url){

        //foi necessario alterar o protocolo http das urls para https por problemas na solocitação
        String base =  "https://swapi.dev/api/films/";
        url = url.replaceAll("http://swapi.dev/api/films/", "");
        url = base + url;
        RestTemplate restTemplate = new RestTemplate();
        
        //o codigo abaixo é responsavel por capturar o nome do filme
        try{
            String response =  restTemplate.getForObject(url, String.class);
            JSONObject obj = new JSONObject(response);
            return obj.getString("title");
        }

        catch(Exception e){
            return "ocorreu um erro na solicitação";
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getTerreno() {
        return terreno;
    }

    public void setTerreno(String terreno) {
        this.terreno = terreno;
    }

    public ArrayList<String> getFilmes() {
        return filmes;
    }

    public void setFilmes(ArrayList<String> filmes) {
        this.filmes = filmes;
    }

    
}