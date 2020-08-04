package com.richard.starwars.controller.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {

    //Tenta decodificar a url para pesquisa do pelo nome do planeta
    public static String decodeParam(String nome) {
        try {
            return URLDecoder.decode(nome, "UTF-8");
        } catch (UnsupportedEncodingException e) {
           return "";
        }
    }
}