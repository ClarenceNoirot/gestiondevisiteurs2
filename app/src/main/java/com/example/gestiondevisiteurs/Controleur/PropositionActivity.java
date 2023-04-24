package com.example.gestiondevisiteurs.Controleur;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gestiondevisiteurs.Modele.Visiteur;
import com.example.gestiondevisiteurs.Modele.VisiteurDAO;
import com.example.gestiondevisiteurs.R;

public class PropositionActivity extends AppCompatActivity {
private Button btnajout,btnconsult,btnmodif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proposition);

         btnajout = (Button) findViewById(R.id.ajout);

        btnajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                // TODO Auto-generated method stub
                Intent intent = new Intent(v.getContext(), AjoutActivity.class);

                startActivity(intent);
            }
        });
        btnconsult = (Button) findViewById(R.id.consult);

        btnconsult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // TODO Auto-generated method stub
                Intent intent = new Intent(v.getContext(), ConsultActivity.class);

                startActivity(intent);
            }
        });


    }
}
