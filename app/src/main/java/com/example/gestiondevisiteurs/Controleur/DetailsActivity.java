package com.example.gestiondevisiteurs.Controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gestiondevisiteurs.Modele.Visiteur;
import com.example.gestiondevisiteurs.Modele.VisiteurDAO;
import com.example.gestiondevisiteurs.R;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {
    private EditText editId, editPrenom, editNom, editLogin, editMdp, editAdresse, editVille, editCp, editDateEmbauche;
    private String id;
    private String nom;
    private String prenom;
    private String adresse;
    private String dateEmbauche;
    private String cp;
    private String ville;
    private String login;
    private String mdp;

    private Button btnValider, btnSup;
    private ArrayList<Visiteur> lesVisiteurs = new ArrayList<Visiteur>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        editId = (EditText) findViewById(R.id.editTextId);
        editPrenom = (EditText) findViewById(R.id.editTextPre);
        editNom = (EditText) findViewById(R.id.editTextNom);
        editLogin = (EditText) findViewById(R.id.editTextLogin);
        editMdp = (EditText) findViewById(R.id.editTextMdp);
        editAdresse = (EditText) findViewById(R.id.editTextAdRue);
        editCp = (EditText) findViewById(R.id.editTextCP);
        editVille = (EditText) findViewById(R.id.editTextVille);
        editDateEmbauche = (EditText) findViewById(R.id.editTextDate);


        id = getIntent().getStringExtra("id");
        prenom = getIntent().getStringExtra("prenom");
        nom = getIntent().getStringExtra("nom");
        login = getIntent().getStringExtra("login");
        mdp = getIntent().getStringExtra("mdp");
        adresse = getIntent().getStringExtra("adresse");
        cp = getIntent().getStringExtra("cp");
        ville = getIntent().getStringExtra("ville");
        dateEmbauche = getIntent().getStringExtra("commentaire");
//rajout nunes
        editId.setText(id);

        editPrenom.setText(prenom);
        editNom.setText(nom);
        editLogin.setText(login);
        editMdp.setText(mdp);
        editAdresse.setText(adresse);
        editCp.setText(adresse);
        editVille.setText(adresse);
        editDateEmbauche.setText(dateEmbauche);

        btnValider = (Button) findViewById(R.id.buttonValiderAjout);
        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
                Intent intent = new Intent(v.getContext(), ConsultActivity.class);
                startActivity(intent);
            }

        });
        btnSup = (Button) findViewById(R.id.supprimer);
        btnSup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
                Intent intent = new Intent(v.getContext(), ConsultActivity.class);
                startActivity(intent);
            }

        });

    }

    private void update() {
        VisiteurDAO visiteur = new VisiteurDAO();
        //ArrayList<Visiteur> lesVisiteurs;

        Visiteur nvVisiteur = new Visiteur(editId.getText().toString(), editPrenom.getText().toString(), editNom.getText().toString(),
                editLogin.getText().toString(), editMdp.getText().toString(), editAdresse.getText().toString(), editCp.getText().toString(),
                editVille.getText().toString(), editDateEmbauche.getText().toString());
        Visiteur ancVisiteur = new Visiteur(id, prenom, nom, login, mdp, adresse, cp, ville, dateEmbauche);
        Log.d("ancvisiteur", ancVisiteur.getId());
        String res = visiteur.updateVisiteur(nvVisiteur, ancVisiteur);
        Log.d("maj", res);
    }

    private void delete() {
    }
}