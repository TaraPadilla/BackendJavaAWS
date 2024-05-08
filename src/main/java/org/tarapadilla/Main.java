package org.tarapadilla;
import okhttp3.*;

import java.io.IOException;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        UIMenu.showMenu();
//        String urlAPI =  "https://www.datos.gov.co/resource/xdk5-pm3f.json?$query=";
//
//        String sqlTodosDptos = "SELECT distinct departamento, c_digo_dane_de    l_departamento ";
//        String sqlorder = "order by departamento asc";
//        String sqlTodosMuni = "SELECT distinct c_digo_dane_del_municipio, municipio ";
//        String sqlorderMun = "order by municipio asc";
//        String sqlFilter = " where c_digo_dane_del_departamento= 5";
//        //urlAPI = urlAPI + sqlTodosDptos + sqlorder;
//        urlAPI = urlAPI + sqlTodosMuni + sqlFilter + sqlorderMun;
//        OkHttpClient client = new OkHttpClient().newBuilder()
//                .build();
//        Request request = new Request.Builder()
//                .url(urlAPI)
//                .method("GET", null)
//                .build();
//        Response response = client.newCall(request).execute();
//        String JSON = response.body().string();
//        JSON = JSON.substring(1, JSON.length() - 1);
//        System.out.println(JSON);
    }
}