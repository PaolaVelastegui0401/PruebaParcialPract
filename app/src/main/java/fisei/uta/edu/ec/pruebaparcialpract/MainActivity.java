package fisei.uta.edu.ec.pruebaparcialpract;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText num1;
    private EditText num2;
    private TextView resp;

    public String[] numerador;
    public String[] denominador;
    public String[] resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1= findViewById(R.id.txt_Numero1);
        num2= findViewById(R.id.txt_Numero2);
        resp = findViewById(R.id.txt_Respuesta);

    }


    public void Sumar(View view){
        String numero1= num1.getText().toString();
        String numero2 = num2.getText().toString();
        String resultado= "";

        int llevo=0;
        int absoluto = numero1.length() - numero2.length();

        if(numero1.length() > numero2.length()){
            int k = 0;
            do{
                numero2 = "0"+ numero2;
                k++;
            }while ( k < absoluto);
        }
        if(numero1.length() < numero2.length()){
            int j = 0;
            do{
                numero1 = "0" + numero1;
                j++;
            }while ( j < absoluto);
        }

        resp.setText(numero1 + "\n" + numero2);

        int i = numero1.length() - 1;
        do{
            String aj = "" + numero1.charAt(i);
            String te = "" + numero2.charAt(i);
            int auxiliar = Integer.parseInt(aj) + Integer.parseInt(te) + llevo;
            if(auxiliar > 9){
                resultado = auxiliar%10 + resultado;
                llevo = auxiliar/10;
            }else{
                resultado = auxiliar + resultado;
                llevo = 0;
            }
            i--;
        }while (i >= 0);

        if(llevo > 0)
            resultado = llevo + resultado;
        resp.setText(resultado);

    }

    public void Restar(View view){
        String numero1 = num1.getText().toString();
        String numero2 = num2.getText().toString();
        String resultado= "";

        int llevo=0;
        int absoluto = numero1.length() - numero2.length();

        if(numero1.length() > numero2.length()){
            int k = 0;
            do{
                numero2 = "0"+ numero2;
                k++;
            }while ( k < absoluto);
        }
        if(numero1.length() < numero2.length()){
            int j = 0;
            do{
                numero1 = "0" + numero1;
                j++;
            }while ( j < absoluto);
        }

        resp.setText(numero1 + "\n" + numero2);

        int i = numero1.length() - 1;
        do{
            String aj=""+numero1.charAt(i);
            String te=""+numero2.charAt(i);
            if((Integer.parseInt(aj) < Integer.parseInt(te))){
                aj = "1" + aj;
            }

            int auxiliar = Integer.parseInt(aj) - Integer.parseInt(te) - llevo;
            if(auxiliar>9){
//                if(auxiliar < 0){
//                    auxiliar = auxiliar * -1;
//                }
                resultado = auxiliar%10 + resultado;
                llevo=auxiliar/10;
            }else{
//                if(auxiliar < 0){
//                    auxiliar = auxiliar * -1;
//                }
                resultado = auxiliar + resultado;
                llevo=0;
            }
            i--;
        }while (i >= 0);

        if(numero1.length() > numero2.length()){
            resultado = "-" + resultado;
        }

        if(llevo>0)
            resultado = llevo + resultado;

        resp.setText(resultado);
    }

    public void oResta(View view) {
        char[] numero1 = num1.getText().toString().toCharArray();
        char[] numero2 = num2.getText().toString().toCharArray();
        //String valor = String.valueOf(numero1[0]);
        int i = 1;
        int j = 1;
        int limitevalor1 = numero1.length - 1;
        int limitevalor2 = numero2.length - 1;
        if (limitevalor1 != limitevalor2) {

        }
        String valorResta = "";
        String cadenaResta = "";
        while ((limitevalor1) != 0) {

            if (Integer.valueOf(numero1[i]) >= Integer.valueOf(numero2[j])) {
                valorResta = String.valueOf(Integer.valueOf(numero1[limitevalor1]) - Integer.valueOf(numero2[j]));
                cadenaResta = cadenaResta + valorResta;
                if (j == limitevalor2) {
                    limitevalor1 = 0;
                }
            } else {
                String valor2 = "1" + String.valueOf(numero1[i]);
                valorResta = String.valueOf(Integer.valueOf(valor2) - numero2[j]);
                String valor3 = String.valueOf(Integer.valueOf(numero2[j]) - 1);
                numero2[j + 1] = valor3.charAt(0);
                cadenaResta = cadenaResta + valorResta;
            }
            i++;
            j++;

            // int resta = Integer.valueOf(numero1[limitevalor1])-Integer.valueOf(numero2[])


        }
        //editTextNumero1.setText(valor);
        resp.setText(cadenaResta);
    }

}