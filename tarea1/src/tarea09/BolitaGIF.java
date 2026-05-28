package tarea09;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class BolitaGIF extends Activity {

    ImageView bolita;
    AnimationDrawable animacion;

    @Override
    protected void onCreate(Bundle si) {
        super.onCreate(si);
        setContentView(R.layout.bolitagif);

        bolita = findViewById(R.id.bolitaanimacion);
        animacion = (AnimationDrawable) bolita.getDrawable();
        animacion.start();
    }
}
