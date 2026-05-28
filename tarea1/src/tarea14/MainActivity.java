package tarea14;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtMensaje;
    Button btnWhatsapp, btnCorreo, btnSMS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMensaje = findViewById(R.id.txtMensaje);
        btnWhatsapp = findViewById(R.id.btnWhatsapp);
        btnCorreo = findViewById(R.id.btnCorreo);
        btnSMS = findViewById(R.id.btnSMS);

        btnWhatsapp.setOnClickListener(v -> {
            String mensaje = txtMensaje.getText().toString();
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://wa.me/525539059687?text=" + Uri.encode(mensaje)));
            startActivity(intent);
        });

        btnCorreo.setOnClickListener(v -> {
            String mensaje = txtMensaje.getText().toString();
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("message/rfc822");
            intent.putExtra(Intent.EXTRA_SUBJECT, "Mensaje desde mi app");
            intent.putExtra(Intent.EXTRA_TEXT, mensaje);
            try {
                startActivity(Intent.createChooser(intent, "Enviar correo"));
            } catch (Exception e) {
                Toast.makeText(this, "No hay app de correo", Toast.LENGTH_SHORT).show();
            }
        });

        btnSMS.setOnClickListener(v -> {
            String mensaje = txtMensaje.getText().toString();
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("sms:"));
            intent.putExtra("sms_body", mensaje);
            startActivity(intent);
        });
    }
}
