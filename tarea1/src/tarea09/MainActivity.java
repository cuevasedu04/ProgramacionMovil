package tarea09;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle si) {
        super.onCreate(si);

        LinearLayout principal = new LinearLayout(this);
        principal.setOrientation(LinearLayout.VERTICAL);

        Button bolitaXML = new Button(this);
        bolitaXML.setText("Bolita XML");
        bolitaXML.setPadding(30, 50, 30, 50);
        bolitaXML.setOnClickListener(v -> startActivity(new Intent(this, BolitaXML.class)));

        Button bolitaImagen = new Button(this);
        bolitaImagen.setText("Bolita Imagen");
        bolitaImagen.setPadding(30, 50, 30, 50);
        bolitaImagen.setOnClickListener(v -> startActivity(new Intent(this, BolitaImagen.class)));

        Button bolitaGIF = new Button(this);
        bolitaGIF.setText("Bolita GIF");
        bolitaGIF.setPadding(30, 50, 30, 50);
        bolitaGIF.setOnClickListener(v -> startActivity(new Intent(this, BolitaGIF.class)));

        principal.addView(bolitaXML);
        principal.addView(bolitaImagen);
        principal.addView(bolitaGIF);

        setContentView(principal);
    }
}
