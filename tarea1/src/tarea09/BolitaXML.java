package tarea09;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class BolitaXML extends Activity {

    View bolita;

    @Override
    protected void onCreate(Bundle si) {
        super.onCreate(si);
        setContentView(R.layout.bolitaxml);
        bolita = findViewById(R.id.bolitaxml);
        bolita.setX(60);
        bolita.setY(60);
    }

    public void retroceder(View v) {
        bolita.setX(bolita.getX() - 30);
    }

    public void avanzar(View v) {
        bolita.setX(bolita.getX() + 30);
    }
}
