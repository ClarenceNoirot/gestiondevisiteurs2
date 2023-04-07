package com.example.gestiondevisiteurs.Controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gestiondevisiteurs.Controleur.PropositionActivity;
import com.example.gestiondevisiteurs.R;

public class MainActivity extends AppCompatActivity {
private Button btnValider;
private EditText textLogin, textMdp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textLogin=(EditText)findViewById(R.id.editTextTextPersonName) ;
        textMdp=(EditText)findViewById(R.id.editTextTextPersonName2);

        btnValider = (Button) findViewById(R.id.buttonValider);


                  btnValider.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {



            // TODO Auto-generated method stub
            Intent intent = new Intent(v.getContext(), PropositionActivity.class);

            startActivity(intent);
        }
    });

}

}