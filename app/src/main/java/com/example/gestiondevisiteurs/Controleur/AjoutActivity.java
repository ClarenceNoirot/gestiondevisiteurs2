package com.example.gestiondevisiteurs.Controleur;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gestiondevisiteurs.Modele.Visiteur;
import com.example.gestiondevisiteurs.Modele.VisiteurDAO;
import com.example.gestiondevisiteurs.R;

public class AjoutActivity extends AppCompatActivity {

    private EditText id, nom, prenom, login, mdp, adresse, cp, ville, dateEmbauche;
    private Button validerAjout;
    private Button retour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);
        validerAjout=findViewById(R.id.buttonValiderAjout);

        validerAjout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ajouter();
                Intent intent = new Intent(v.getContext(), PropositionActivity.class);
                startActivity(intent);
            }
        });

    }
    private void ajouter(){
        id=(EditText)findViewById(R.id.editTextId);
        nom=(EditText)findViewById(R.id.editTextNom);
        prenom=(EditText)findViewById(R.id.editTextPre);
        login=(EditText)findViewById(R.id.editTextLogin);
        mdp=(EditText)findViewById(R.id.editTextMdp);
        adresse=(EditText)findViewById(R.id.editTextAdRue);
        cp=(EditText)findViewById(R.id.editTextCP);
        ville=(EditText)findViewById(R.id.editTextVille);
        dateEmbauche=(EditText)findViewById(R.id.editTextDate);

        VisiteurDAO visiteurAcces = new VisiteurDAO();
        Visiteur unVisiteur= new Visiteur(id.getText().toString(), nom.getText().toString(), prenom.getText().toString(), login.getText().toString(), mdp.getText().toString(), adresse.getText().toString(),
                cp.getText().toString(), ville.getText().toString(), dateEmbauche.getText().toString());
        String resultat=visiteurAcces.addVisiteur(unVisiteur);
        Log.d("ajouter",resultat);
    }
}
