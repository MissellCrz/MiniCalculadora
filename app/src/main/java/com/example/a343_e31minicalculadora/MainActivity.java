package com.example.a343_e31minicalculadora;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Referencias a las vistas
    private TextView mResultado;
    private EditText mValor1, mValor2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Se instancian las vistas
        mResultado = findViewById(R.id.resultado);
        mValor1 = findViewById(R.id.valor1);
        mValor2 = findViewById(R.id.valor2);

        //Para el icono en ActionBar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
    }

    public void fnSuma(View view) {
        try {
            // Se leen los valores
            String sValor1 = mValor1.getText().toString();
            String sValor2 = mValor2.getText().toString();

            // se convierten los valores a double
            double dValor1 = Double.parseDouble(sValor1);
            double dValor2 = Double.parseDouble(sValor2);

            // obtenemos la suma y la ponemos en resultado
            mResultado.setText((dValor1+dValor2)+ "");
        }catch (NumberFormatException e){
            Toast.makeText(this,"Favor de rellenar los valores correspondientes",Toast.LENGTH_LONG).show();

        }

    }

    public void fnResta(View view) {
        String sValor1 = mValor1.getText().toString();
        String sValor2 = mValor2.getText().toString();

        boolean noVacio = Verificar(sValor1, sValor2);
        if(!noVacio) return;

        double dValor1 = Double.parseDouble(sValor1);
        double dValor2 = Double.parseDouble(sValor2);

        mResultado.setText((dValor1-dValor2)+"");
    }

    public void fnMulti(View view) {
        String sValor1 = mValor1.getText().toString();
        String sValor2 = mValor2.getText().toString();

        boolean noVacio = Verificar(sValor1, sValor2);
        if(!noVacio) return;

        double dValor1 = Double.parseDouble(sValor1);
        double dValor2 = Double.parseDouble(sValor2);

        mResultado.setText((dValor1*dValor2)+"");
    }

    public void fnDivi(View view) {
        String sValor1 = mValor1.getText().toString();
        String sValor2 = mValor2.getText().toString();

        boolean noVacio = Verificar(sValor1, sValor2);
        if(!noVacio) return;

        double dValor1 = Double.parseDouble(sValor1);
        double dValor2 = Double.parseDouble(sValor2);

        boolean Cero = vCero(dValor2);
        if(Cero) return;

        mResultado.setText((dValor1/dValor2)+"");
    }

    public void fnClear(View view) {
        mResultado.setText("0");
        mValor1.setText("");
        mValor2.setText("");
    }
    public boolean Verificar (String v1, String v2){
        if(v1.equals("") || v2.equals("")){
            //crearDialog("Favor de llenar los dos valores.");
            Toast.makeText(this, "Favor de llenar los dos valores.", Toast.LENGTH_SHORT).show();
            return false;
        }else{
            return true;
        }
    }
    public boolean vCero (double v2){
        if(v2 == 0){
             crearDialog("No se puede dividir entre 0");
            Toast.makeText(this, "No se puede dividir entre 0.", Toast.LENGTH_SHORT).show();
            return true;
        }else{
            return false;
        }
    }

    private void crearDialog(String s) {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
        dialogo.setMessage(s);

        dialogo.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //nadaaaaaaaaaaaaa
            }
        });
        dialogo.show();
    }

}