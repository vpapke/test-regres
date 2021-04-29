package br.com.regresrestassuredapitest.utils;

import org.json.simple.JSONObject;

public class Utils {
    public static  String getContractsBasePath(String pack, String contract) {
        return System.getProperty("user.dir")
                + "/src/test/java/br/com/regresrestassuredapitest/tests/"
                + pack
                + "/contracts/"
                + contract
                + ".json";
    }

    public static JSONObject validCorpoUser(){
        JSONObject corpo = new JSONObject();
        corpo.put("nome","Ronaldo");
        corpo.put("job","artilheiro");
        return corpo;
    }
    public static JSONObject validCorpoLogin(){
        JSONObject corpo = new JSONObject();
        corpo.put("email","janet.weaver@reqres.in");
        corpo.put("password","a1b2c3d4e5");
        return corpo;
    }

    public static JSONObject invalidCorpoLogin(){
        JSONObject corpo = new JSONObject();
        corpo.put("email","teste@teste.com");
        return corpo;
    }


}
