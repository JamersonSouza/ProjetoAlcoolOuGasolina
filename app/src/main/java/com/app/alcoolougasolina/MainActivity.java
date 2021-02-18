package com.app.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText precoGasolina, precoAlcool;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        precoGasolina = findViewById(R.id.precoGasolina);
        precoAlcool = findViewById(R.id.precoAlcool);
        textResultado = findViewById(R.id.textResultado);
    }

    public void CalcularPreco(View view){
        //captura os dados informados
        String editPrecoAlcool = precoAlcool.getText().toString();
        String editPrecoGasolina = precoGasolina.getText().toString();

        Boolean camposvalidados = validaDados(editPrecoAlcool, editPrecoGasolina);

        if(camposvalidados){

            //convertendo String para numeros
            Double valorAlcool = Double.parseDouble(editPrecoAlcool);
            Double valorGasolina = Double.parseDouble(editPrecoGasolina);

            /*
            Se o (valorAlcool/valorGasolina) é >= 0.7 o melhor é utilizar
            gasolina.
            senão melhor usar alcool
             */
            double valor = 0.7;
            if((valorAlcool / valorGasolina) >= valor){
                textResultado.setText("É melhor usar Gasolina");
            }else if((valorAlcool / valorGasolina) < valor){
                textResultado.setText("É melhor usar Alcool");
            }

          }else{
            textResultado.setText("Preencha os preços primeiro");
        }
    }

    //valida se foi digitado os dados solitados
    public Boolean validaDados(String pAlcool, String pGasolina){
            Boolean camposvalidados = true;

            if(pAlcool == null || pAlcool.equals("")){
                    camposvalidados = false;
            }else if(pGasolina == null || pGasolina.equals("")){
                camposvalidados = false;
            }

            return camposvalidados;
    }

}
