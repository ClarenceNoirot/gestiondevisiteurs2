package com.example.gestiondevisiteurs.Controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.gestiondevisiteurs.Modele.Visiteur;
import com.example.gestiondevisiteurs.Modele.VisiteurDAO;
import com.example.gestiondevisiteurs.R;

import java.util.ArrayList;

public class ConsultActivity extends AppCompatActivity {
    private EditText txtid, txtPrenom,txtNom,txtVille,txtCp,txtDateEmbauche,txtAdresse,txtLogin,txtMdp;
private Button btnretour;
private ListView listview;
private ArrayList<Visiteur> lesVisiteur=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult);

        txtid=(EditText)findViewById(R.id.editTextId);
        txtNom=(EditText)findViewById(R.id.editTextNom);
        txtPrenom=(EditText)findViewById(R.id.editTextPre);
        txtAdresse=(EditText)findViewById(R.id.editTextAdRue);
        txtLogin=(EditText)findViewById(R.id.editTextLogin);
        txtCp=(EditText)findViewById(R.id.editTextCP);
        txtMdp=(EditText)findViewById(R.id.editTextMdp);
        txtVille=(EditText)findViewById(R.id.editTextVille);
        txtDateEmbauche=(EditText)findViewById(R.id.editTextDate);

       listview=(ListView)findViewById(R.id.listview);
        VisiteurDAO visiteurDAO=new VisiteurDAO();
       lesVisiteur= visiteurDAO.recupVisiteur();
        ArrayAdapter monAdapter = new ArrayAdapter(ConsultActivity.this, android.R.layout.simple_list_item_1, lesVisiteur);
        listview.setAdapter(monAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Visiteur selectedItem = (Visiteur) listview.getAdapter().getItem(position);
                Log.d("selection",selectedItem.toString());
                Intent i = new Intent(ConsultActivity.this, DetailsActivity.class);
                i.putExtra("pos", position);
                i.putExtra("id", selectedItem.getId());
                i.putExtra("prenom", selectedItem.getPrenom());
                i.putExtra("nom", selectedItem.getNom());
                i.putExtra("login", selectedItem.getLogin());
                i.putExtra("mdp", selectedItem.getMdp());
                i.putExtra("adresse", selectedItem.getAdresse());
                i.putExtra("cp", selectedItem.getCp());
                i.putExtra("ville", selectedItem.getville());
                i.putExtra("dateEmbauche", selectedItem.getDateEmbauche());
                startActivity(i);
            }
        });

        btnretour = (Button) findViewById(R.id.retour);

        btnretour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                // TODO Auto-generated method stub
                Intent intent = new Intent(v.getContext(), PropositionActivity.class);

                startActivity(intent);
            }

        });
    }

    private void foreach() {
    }
}