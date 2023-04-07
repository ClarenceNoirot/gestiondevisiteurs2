package com.example.gestiondevisiteurs.Modele;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class VisiteurDAO {

    public VisiteurDAO() {
    }


    public String addVisiteur(Visiteur unVisiteur) {
        String result = "";
        //adresse de l'URL de l\'API à interroger et fichier php permettant d'\ajouter le visiteur
        String myUrl = "https://noirot.alwaysdata.net/API/addVisiteur.php";
        //informations à transmettre pour effectuer l'ajout
        String params =
                "id=" + unVisiteur.getId() + "&nom=" + unVisiteur.getNom() +
                        "&prenom=" + unVisiteur.getPrenom() +
                        "&login=" + unVisiteur.getLogin() +
                        "&mdp=" + unVisiteur.getMdp() +
                        "&adresse=" + unVisiteur.getAdresse() +
                        "&cp=" + unVisiteur.getCp() +
                        "&ville=" + unVisiteur.getville() +
                        "&dateEmbauche=" + unVisiteur.getDateEmbauche();
        Log.d("requete", params);

        HttpPostRequest postRequest = new HttpPostRequest();
        try {
            result = postRequest.execute(new String[]{myUrl, params}).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Log.d("resultat", result);
        return result;
    }

    public ArrayList<Visiteur> recupVisiteur() {
        String result = "";
        ArrayList<Visiteur> lesVisiteurs = new ArrayList<Visiteur>();

        String myUrl = "https://noirot.alwaysdata.net/API/getVisiteurs.php";
        String params = "";
        HttpPostRequest getRequest = new HttpPostRequest();
        try {
            result = getRequest.execute(new String[]{myUrl, params}).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        try {

            JSONArray tabJson = new JSONArray(result);
            Visiteur unVisiteur;
            for (int i = 0; i < tabJson.length(); i++) {
                String id = tabJson.getJSONObject(i).getString("id");
                String resNom = tabJson.getJSONObject(i).getString("nom");
                String resPrenom = tabJson.getJSONObject(i).getString("prenom");
                String resLogin = tabJson.getJSONObject(i).getString("login");
                String resMdp = tabJson.getJSONObject(i).getString("mdp");
                String resAdresse = tabJson.getJSONObject(i).getString("adresse");
                String resCP = tabJson.getJSONObject(i).getString("cp");
                String resVille = tabJson.getJSONObject(i).getString("ville");
                String resDateE = tabJson.getJSONObject(i).getString("dateEmbauche");
                lesVisiteurs.add(new Visiteur(id, resNom, resPrenom, resLogin, resMdp, resAdresse, resCP, resVille, resDateE));
                unVisiteur = new Visiteur(id, resNom, resPrenom, resLogin, resMdp, resAdresse, resCP, resVille, resDateE);
                Log.d("un visiteur", unVisiteur.toString());
                lesVisiteurs.add(unVisiteur);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return lesVisiteurs;
    }

    public String updateVisiteur(Visiteur nvVisiteur, Visiteur ancVisiteur) {
        String result = "";
        String myUrl = "https://noirot.alwaysdata.net/API/modifVisiteurByIdV.php";
        String params =
                "id=" + nvVisiteur.getId() + "&nom=" + nvVisiteur.getNom() +
                        "&prenom=" + nvVisiteur.getPrenom() +
                        "&login=" + nvVisiteur.getLogin() +
                        "&mdp=" + nvVisiteur.getMdp() +
                        "&adresse=" + nvVisiteur.getAdresse() +
                        "&cp=" + nvVisiteur.getCp() +
                        "&ville=" + nvVisiteur.getville() +
                        "&dateEmbauche=" + nvVisiteur.getDateEmbauche();
        Log.d("requete", params);


        HttpPostRequest postRequest = new HttpPostRequest();
        try {
            result = postRequest.execute(new String[]{myUrl, params}).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Log.d("resultat", result);
        return result;

    }
}
