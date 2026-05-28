package tarea08;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle si) {
        super.onCreate(si);
        setContentView(R.layout.principal);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getTitle() + "") {
            case "formulario":
                abrirFormulario();
                return true;
            case "listado":
                abrirListado();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void abrirFormulario() {
        startActivity(new Intent(this, Formulario.class));
    }

    public void abrirListado() {
        startActivity(new Intent(this, Listado.class));
    }
}
