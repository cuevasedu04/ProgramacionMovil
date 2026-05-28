package tarea08;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class Formulario extends Activity {

    TextView nombre;
    RadioButton masculino, femenino;
    Button btnEnviarDatos;
    TextView datosEnviados;

    @Override
    protected void onCreate(Bundle si) {
        super.onCreate(si);
        setContentView(R.layout.formulariovista);

        nombre = findViewById(R.id.nombreusuario);
        masculino = findViewById(R.id.masculino);
        femenino = findViewById(R.id.femenino);
        btnEnviarDatos = findViewById(R.id.enviardatos);
        datosEnviados = findViewById(R.id.datos);

        btnEnviarDatos.setOnClickListener(v -> {
            String n = nombre.getText().toString();
            String s = masculino.isChecked() ? "masculino" : "femenino";
            datosEnviados.setText("Tu nombre es: " + n + ", tu sexo es: " + s);
        });
    }
}
