package tarea10;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

    ImageView imageView;
    Button btnAdelante, btnAtras, btnSaltar;
    boolean saltando = false;

    int[] caminar = {
        R.drawable.camina1,
        R.drawable.camina2,
        R.drawable.camina3
    };

    int reposo = R.drawable.inactivo;

    int index = 0;
    boolean animando = false;
    boolean adelante = true;

    Handler handler = new Handler();
    float posX;
    int velocidad = 50;

    Runnable animacion = new Runnable() {
        @Override
        public void run() {
            if (animando) {
                imageView.setImageResource(caminar[index]);

                if (adelante) {
                    index++;
                    if (index >= caminar.length) {
                        index = 0;
                        posX += velocidad;
                    }
                } else {
                    index--;
                    if (index < 0) {
                        index = caminar.length - 1;
                        posX -= velocidad;
                    }
                }
                imageView.setX(posX);
                handler.postDelayed(this, 150);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        btnAdelante = findViewById(R.id.btnAdelante);
        btnAtras = findViewById(R.id.btnAtras);
        btnSaltar = findViewById(R.id.btnSaltar);

        imageView.post(() -> posX = imageView.getX());
        imageView.setImageResource(reposo);

        btnAdelante.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    adelante = true;
                    posX += 30;
                    imageView.setScaleX(1f);
                    animando = true;
                    handler.post(animacion);
                    break;
                case MotionEvent.ACTION_UP:
                    detenerAnimacion();
                    break;
            }
            return true;
        });

        btnAtras.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    adelante = false;
                    imageView.setScaleX(-1f);
                    animando = true;
                    handler.post(animacion);
                    break;
                case MotionEvent.ACTION_UP:
                    detenerAnimacion();
                    break;
            }
            return true;
        });

        btnSaltar.setSoundEffectsEnabled(false);
        btnSaltar.setOnClickListener(v -> {
            if (saltando) return;
            saltando = true;
            imageView.setImageResource(R.drawable.salto);
            imageView.animate()
                .translationYBy(-200f)
                .setDuration(200)
                .withEndAction(() ->
                    imageView.animate()
                        .translationYBy(200f)
                        .setDuration(200)
                        .withEndAction(() -> {
                            imageView.setImageResource(reposo);
                            saltando = false;
                        })
                );
        });
    }

    private void detenerAnimacion() {
        animando = false;
        handler.removeCallbacks(animacion);
        imageView.setImageResource(reposo);
    }
}
