package tarea12;

import android.os.Bundle;
import android.app.Activity;
import android.os.Handler;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

    ImageView marco;
    int[] imagenes = {
        R.drawable.gato,
        R.drawable.vaca,
        R.drawable.perro
    };

    int contador;
    Button btnAtras, btnAdelante;
    boolean batras, badelante;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle si) {
        super.onCreate(si);
        setContentView(R.layout.galeria);

        marco = findViewById(R.id.imageview);
        btnAtras = findViewById(R.id.btnatras);
        btnAdelante = findViewById(R.id.btnadelante);

        mostrarImagen();

        btnAtras.setOnClickListener(v -> {
            batras = true;
            cambiarImagen();
        });

        btnAdelante.setOnTouchListener((view, motionEvent) -> {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    badelante = true;
                    cambiarImagen();
                    return true;
                case MotionEvent.ACTION_UP:
                    badelante = false;
                    return true;
            }
            return false;
        });
    }

    public void cambiarImagen() {
        handler.postDelayed(() -> {
            if (batras) {
                badelante = false;
                contador--;
                if (contador < 0) contador = imagenes.length - 1;
            }
            if (badelante) {
                batras = false;
                contador++;
                if (contador == imagenes.length) contador = 0;
            }
            mostrarImagen();
            cambiarImagen();
        }, 150);
    }

    public void mostrarImagen() {
        marco.setImageResource(imagenes[contador]);
    }
}
