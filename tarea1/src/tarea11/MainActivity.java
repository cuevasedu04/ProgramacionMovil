package tarea11;

import android.os.Bundle;
import android.app.Activity;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

    ImageView lienzo;
    int[] imagenes = {R.drawable.gato, R.drawable.vaca, R.drawable.perro};

    Button btnAtras, btnAdelante;
    int contador = 0;
    boolean cambiando;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle si) {
        super.onCreate(si);
        setContentView(R.layout.galeria);

        lienzo = findViewById(R.id.marco);
        lienzo.setImageResource(R.drawable.vaca);

        btnAtras = findViewById(R.id.btnatras);
        btnAdelante = findViewById(R.id.btnadelante);

        btnAtras.setOnClickListener(v -> {
            contador = (contador == 0) ? imagenes.length - 1 : contador - 1;
            mostrarImagen();
        });

        btnAdelante.setOnTouchListener((view, motionEvent) -> {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    cambiando = true;
                    cambiarImagen();
                    return true;
                case MotionEvent.ACTION_UP:
                    cambiando = false;
                    return true;
            }
            return false;
        });
    }

    public void cambiarImagen() {
        handler.postDelayed(() -> {
            if (cambiando) {
                contador = (contador + 1) % imagenes.length;
                mostrarImagen();
                cambiarImagen();
            }
        }, 300);
    }

    public void mostrarImagen() {
        lienzo.setImageResource(imagenes[contador]);
    }
}
