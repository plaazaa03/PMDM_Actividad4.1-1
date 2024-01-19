package com.dam.pmdm_actividad41_1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;

import java.text.AttributedCharacterIterator;

// Creacion de la clase Cuenta Bancaria, para luego realizar la herencia a la clase Main.
public class CuentaBancaria extends androidx.appcompat.widget.AppCompatEditText {


    //Constructor
    public CuentaBancaria(Context context, AttributeSet attrs){
        super(context, attrs);
        cuentaNumeros();
    }

    // Funcion para que el limite sea 16 numeros y se agrege el - y  cambio de color de kas letras y el fondo
    private void cuentaNumeros() {
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            // Despues de introducir numeros
            @Override
            public void afterTextChanged(Editable s) {
            String text = s.toString().replaceAll("-","");

            // Longuitud maxima de 16 numeros
            if (text.length() > 16){
                s.delete(16, text.length());
                return;
            }

            StringBuilder stringBuilder = new StringBuilder();

            // Cuando se excriban 4 numeros que aparezca -
            for (int i = 0; i < text.length(); i++){
                if (i > 0 && i % 4 == 0){
                    stringBuilder.append("-");
                }
                // lo añadimos
                stringBuilder.append(text.charAt(i));
            }
            removeTextChangedListener(this);
            setText(stringBuilder.toString());
            setSelection(stringBuilder.length());
            addTextChangedListener(this);

            // le agregamo un color de fondo y de letra cuuando el numero es de 16

            if (text.length() == 16){
                setBackgroundColor(Color.BLUE);
                setTextColor(Color.WHITE);
                setEnabled(false);
            }else {
                setTextColor(Color.BLACK);
                setBackgroundColor(Color.WHITE);
                setEnabled(true);

            }
            
            
            }



        });





    }


}
