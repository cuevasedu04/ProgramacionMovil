Codigo tarea08= 
//////////////////////res/menu/menu xml
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android"&gt;
<item android:id="@+id/file"
android:title="M E N U" >
<!-- "file" submenu -->
<menu>
<item android:id="@+id/itemformulario"
android:title="formulario" />
<item android:id="@+id/itemlistado"
android:title="listado" />
</menu>
</item>
</menu>



///////////////////vista principal xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
xmlns:android="http://schemas.android.com/apk/res/android&quot;
xmlns:app="http://schemas.android.com/apk/res-auto&quot;
xmlns:tools="http://schemas.android.com/tools&quot;
android:layout_width="match_parent"
android:layout_height="match_parent"
tools:context=".MainActivity">

<androidx.appcompat.widget.Toolbar
android:id="@+id/toolbar"
android:layout_width="0dp"
android:layout_height="?attr/actionBarSize"
android:background="#0000FF"
android:titleTextColor="#FFFFFF"
app:layout_constraintTop_toTopOf="parent"
app:layout_constraintStart_toStartOf="parent"
app:layout_constraintEnd_toEndOf="parent"/>

</androidx.constraintlayout.widget.ConstraintLayout>

////////////////////////controlador MainActivity java


package com.example.androidya;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity{

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
// Handle item selection.
switch (item.getTitle()+"") {
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

public void abrirFormulario(){
Intent i = new Intent(this, Formulario.class);
startActivity(i);
}

public void abrirListado(){
Intent i = new Intent(this, Listado.class);
startActivity(i);
}

}

////////////////////////////configuracion manifest

<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android&quot;
xmlns:tools="http://schemas.android.com/tools"&gt;

<application
android:allowBackup="true"
android:dataExtractionRules="@xml/data_extraction_rules"
android:fullBackupContent="@xml/backup_rules"
android:icon="@mipmap/ic_launcher"
android:label="@string/app_name"
android:roundIcon="@mipmap/ic_launcher_round"
android:supportsRtl="true"
android:theme="@style/Theme.Androidya">
<activity
android:name=".MainActivity"
android:exported="true">
<intent-filter>
<action android:name="android.intent.action.MAIN" />

<category android:name="android.intent.category.LAUNCHER" />
</intent-filter>
</activity>

<activity android:name=".Formulario"/>
<activity android:name=".Listado"/>
</application>

</manifest>

////////////////////////////

package com.example.androidya;

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

btnEnviarDatos.setOnClickListener(v->{
String n = nombre.getText()+"";
String s = null;
if(masculino.isChecked()){
s="masculino";
}else{
s="femenino";
}
datosEnviados.setText("Tu nombre es: " + n +", tu sexo es: " + s);
});
}
}

///////////////////////////////////////

package com.example.androidya;

import android.app.Activity;
import android.os.Bundle;

public class Listado extends Activity {
@Override
protected void onCreate(Bundle si) {
super.onCreate(si);
setContentView(R.layout.listavista);


}
}


Codigo tarea09= 
///////////////manifest

<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android&quot;
xmlns:tools="http://schemas.android.com/tools"&gt;

<application
android:allowBackup="true"
android:dataExtractionRules="@xml/data_extraction_rules"
android:fullBackupContent="@xml/backup_rules"
android:icon="@mipmap/ic_launcher"
android:label="@string/app_name"
android:roundIcon="@mipmap/ic_launcher_round"
android:supportsRtl="true"
android:theme="@style/Theme.Bolitas">
<activity
android:name=".MainActivity"
android:exported="true">
<intent-filter>
<action android:name="android.intent.action.MAIN" />

<category android:name="android.intent.category.LAUNCHER" />
</intent-filter>
</activity>

<activity android:name=".BolitaXML"/>

<activity android:name=".BolitaImagen"/>

<activity android:name=".BolitaGIF"/>
</application>

</manifest>


////////////////main controlador

package com.example.bolitas;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

@Override
protected void onCreate(Bundle si) {
super.onCreate(si);

LinearLayout principal = new LinearLayout(this);
principal.setOrientation(LinearLayout.VERTICAL);

Button bolitaXML = new Button(this);
bolitaXML.setText("Bolita XML");
bolitaXML.setPadding(30,50,30,50);
bolitaXML.setOnClickListener(v->{
Intent i = new Intent(this, BolitaXML.class);
startActivity(i);
});

Button bolitaImagen = new Button(this);
bolitaImagen.setText("Bolita Imagen");
bolitaImagen.setPadding(30,50,30,50);
bolitaImagen.setOnClickListener(v->{
Intent i = new Intent(this, BolitaImagen.class);
startActivity(i);
});


Button bolitaGIF = new Button(this);
bolitaGIF.setText("Bolita GIF");
bolitaGIF.setPadding(30,50,30,50);
bolitaGIF.setOnClickListener(v->{
Intent i = new Intent(this, BolitaGIF.class);
startActivity(i);
});



principal.addView(bolitaXML);
principal.addView(bolitaImagen);

principal.addView(bolitaGIF);

setContentView(principal);

}
}

////////////////bolita xml

package com.example.bolitas;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class BolitaXML extends Activity {
View bolita;
int movX;

@Override
protected void onCreate(Bundle si) {
super.onCreate(si);
setContentView(R.layout.bolitaxml);
bolita = findViewById(R.id.bolitaxml);
bolita.setX(60);
bolita.setY(60);
}

public void retroceder(View v){
bolita.setX(bolita.getX()-30);
}

public void avanzar(View v){
bolita.setX(bolita.getX()+30);
}
}

/////////////7 xml bolita

<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android&quot;
android:shape="oval">
<solid android:color="#CCCCCC"/>
</shape>

/////////////////bolita imagen controlador

package com.example.bolitas;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;

public class BolitaImagen extends Activity {
@Override
public void onCreate(Bundle si){
super.onCreate(si);
setContentView(R.layout.bolitaimagen);
}
}

/////////////bolita imagen xml

<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android&quot;
android:layout_width="match_parent"
android:layout_height="match_parent">

<ImageView
android:layout_width="40dp"
android:layout_height="40dp"
android:src="@drawable/bolita"/>

</RelativeLayout>

///////////////bolita gif

package com.example.bolitas;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
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
animacion = (AnimationDrawable)bolita.getDrawable();
animacion.start();
}
}


////////////////7vista bolita gif que carga otro xml animacion

<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android&quot;
android:layout_width="match_parent"
android:layout_height="match_parent">

<ImageView
android:id="@+id/bolitaanimacion"
android:layout_width="40dp"
android:layout_height="40dp"
android:src="@drawable/bolita_animacion"/>

</RelativeLayout>

//////////////////////// bolita_animacion xml

<?xml version="1.0" encoding="utf-8"?>
<animation-list xmlns:android="http://schemas.android.com/apk/res/android&quot;
android:oneshot="false">

<item android:drawable="@drawable/bolita1" android:duration="150"/>
<item android:drawable="@drawable/bolita2" android:duration="150"/>
<item android:drawable="@drawable/bolita3" android:duration="150"/>

</animation-list>

codigo tarea 10 vista mario:
/////////////vista mario
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
xmlns:android="http://schemas.android.com/apk/res/android&quot;
android:orientation="vertical"
android:gravity="center"
android:layout_width="match_parent"
android:layout_height="match_parent">

<ImageView
android:id="@+id/imageView"
android:layout_width="200dp"
android:layout_height="200dp"
android:layout_marginBottom="20dp"
android:scaleType="fitCenter"/>

<LinearLayout
android:orientation="horizontal"
android:layout_width="wrap_content"
android:layout_height="wrap_content">

<Button
android:id="@+id/btnAtras"
android:text="atras"
android:layout_width="wrap_content"
android:layout_height="wrap_content"/>

<Button
android:id="@+id/btnAdelante"
android:text="adelante"
android:layout_width="wrap_content"
android:layout_height="wrap_content"/>

<Button
android:id="@+id/btnSaltar"
android:text="salto"
android:layout_width="wrap_content"
android:layout_height="wrap_content"/>

</LinearLayout>

</LinearLayout>

//////////////////controlador mario
package com.example.mario;

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
// Frames de animación (caminar)
int[] caminar = {
R.drawable.camina1,
R.drawable.camina2,
R.drawable.camina3 };

// Frame de reposo
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
handler.postDelayed(this, 150); // velocidad animación
}
}
};


@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

imageView = (ImageView) findViewById(R.id.imageView);
btnAdelante = (Button) findViewById(R.id.btnAdelante);
btnAtras = (Button) findViewById(R.id.btnAtras);
btnSaltar = (Button)findViewById(R.id.btnSaltar);

posX = imageView.getX();

// Estado inicial
imageView.setImageResource(reposo);

// BOTÓN ADELANTE
btnAdelante.setOnTouchListener(new View.OnTouchListener() {
@Override
public boolean onTouch(View v, MotionEvent event) {

switch (event.getAction()) {
case MotionEvent.ACTION_DOWN:
adelante = true;
posX = posX+30;
imageView.setScaleX(1f);
animando = true;
handler.post(animacion);
break;

case MotionEvent.ACTION_UP:
detenerAnimacion();
break;
}
return true;
}
});

// BOTÓN ATRÁS
btnAtras.setOnTouchListener(new View.OnTouchListener() {
@Override
public boolean onTouch(View v, MotionEvent event) {

switch (event.getAction()) {
case MotionEvent.ACTION_DOWN:
adelante = false;
animando = true;
imageView.setScaleX(-1f);
handler.post(animacion);
break;

case MotionEvent.ACTION_UP:
detenerAnimacion();
break;
}
return true;
}
});

imageView.post(new Runnable() {
@Override
public void run() {
posX = imageView.getX();
}
});


btnSaltar.setSoundEffectsEnabled(false);
btnSaltar.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {

if (saltando) return;

saltando = true;

// 👉 Cambiar a imagen de salto
imageView.setImageResource(R.drawable.salto);

// SUBE
imageView.animate()
.translationYBy(-200f)
.setDuration(200)
.withEndAction(new Runnable() {
@Override
public void run() {

// BAJA
imageView.animate()
.translationYBy(200f)
.setDuration(200)
.withEndAction(new Runnable() {
@Override
public void run() {

// 👉 Volver a reposo
imageView.setImageResource(reposo);

saltando = false;
}
});
}
});
}
});
}

private void detenerAnimacion() {
animando = false;
handler.removeCallbacks(animacion);
imageView.setImageResource(reposo);
}
} 

codigo tarea 11: 
hilo con galeria

///////////vista galeria
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android&quot;
android:layout_width="match_parent"
android:layout_height="match_parent"
android:orientation="vertical">

<ImageView
android:id="@+id/marco"
android:layout_width="match_parent"
android:layout_height="wrap_content"
android:layout_weight="1"/>

<LinearLayout
android:layout_weight="1"
android:layout_width="match_parent"
android:layout_height="wrap_content"
android:orientation="horizontal"
android:background="@color/black">

<Button
android:layout_weight="1"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:id="@+id/btnatras"
android:text="atras"/>


<Button
android:layout_weight="1"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:id="@+id/btnadelante"
android:text="adelante"/>

</LinearLayout>

</LinearLayout>







package com.example.galeria;

import android.os.Bundle;
import android.app.Activity;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
ImageView lienzo;

int imagenes [] = {R.drawable.gato, R.drawable.vaca, R.drawable.perro};

Button btnAtras, btnAdelante;

int contador = 0;
int indice = 0 ;

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

btnAtras.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
if(contador==0){
contador = imagenes.length-1;
}else{
contador--;
}
mostrarImagen();
//Toast.makeText(MainActivity.this, "indice" + contador, Toast.LENGTH_SHORT).show();
}
});

/*
btnAdelante.setOnClickListener(v->{
if(contador==imagenes.length-1){
contador = 0;
}else{
contador++;
}
mostrarImagen();
//Toast.makeText(MainActivity.this, "indice" + contador, Toast.LENGTH_SHORT).show();
});

*/
btnAdelante.setOnTouchListener((view, motionEvent) -> {
switch (motionEvent.getAction()){
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

}//fin onCreate


public void cambiarImagen(){
handler.postDelayed(()->{

if(cambiando){
contador++;
if(contador>= imagenes.length){
contador=0;
}
mostrarImagen();
cambiarImagen();
}

},300);

}

public void mostrarImagen(){
lienzo.setImageResource(imagenes[contador]);
}
}

codigo tarea 12: 

package com.example.galeria;

import android.os.Bundle;
import android.app.Activity;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
ImageView marco;

int [] imagenes = {
R.drawable.gato,
R.drawable.vaca,
R.drawable.perro };

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

btnAtras.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
batras = true;
cambiarImagen();
}
});

/*
btnAdelante.setOnTouchListener(new View.OnTouchListener() {
@Override
public boolean onTouch(View view, MotionEvent motionEvent) {

switch(motionEvent.getAction()){
case MotionEvent.ACTION_DOWN:
badelante = true;
cambiarImagen();
return true;
case MotionEvent.ACTION_UP:
batras = false;
return true;
}

return false;
}
});
}*/

btnAdelante.setOnTouchListener((view, motionEvent)->{

switch(motionEvent.getAction()){
case MotionEvent.ACTION_DOWN:
badelante = true;
cambiarImagen();
return true;
case MotionEvent.ACTION_UP:
batras = false;
return true;
}

return false;

});
}

/*
public void cambiarImagen(){
if(batras){
badelante = false;
contador--;
if(contador<0){
contador = imagenes.length-1;
}
}
if(badelante){
batras = false;
contador++;
if(contador==imagenes.length){
contador = 0;
}
}
mostrarImagen();
}
*/


public void cambiarImagen(){
handler.postDelayed(()->
{
if (batras) {
badelante = false;
contador--;
if (contador < 0) {
contador = imagenes.length - 1;
}
}
if (badelante) {
batras = false;
contador++;
if (contador == imagenes.length) {
contador = 0;
}
}

mostrarImagen();
cambiarImagen();

}
,150);

}
public void mostrarImagen(){
marco.setImageResource(imagenes[contador]);

}
}

codigo tarea 13: 

package com.example.memorama;

import android.os.Bundle;
import android.app.Activity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
WebView webview;

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.principal);

webview = findViewById(R.id.exploradorweb);

WebSettings webSettings = webview.getSettings();
webSettings.setJavaScriptEnabled(true);
webview.setInitialScale(100);
webview.setWebViewClient(new WebViewClient());
// Cargar tu URI (puede ser http://, https:// o file://)
String url = "https://pw1515-36409.web.app&quot;;
webview.loadUrl(url);

}
}

codigo tarea 14: 
Programa que envia mensajes, whatapp, correo, sms version 1 abriendo las apps

/// vista
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
xmlns:android="http://schemas.android.com/apk/res/android&quot;
android:layout_width="match_parent"
android:layout_height="match_parent"
android:orientation="vertical"
android:padding="20dp">

<EditText
android:id="@+id/txtMensaje"
android:layout_width="match_parent"
android:layout_height="wrap_content"
android:hint="Escribe un mensaje"/>

<Button
android:id="@+id/btnWhatsapp"
android:layout_width="match_parent"
android:layout_height="wrap_content"
android:text="Enviar a WhatsApp"/>

<Button
android:id="@+id/btnCorreo"
android:layout_width="match_parent"
android:layout_height="wrap_content"
android:text="Enviar por Correo"/>

<Button
android:id="@+id/btnSMS"
android:layout_width="match_parent"
android:layout_height="wrap_content"
android:text="Enviar por SMS"/>

</LinearLayout>



/////////controlador

package com.example.mensajes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
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

//WHATSAPP
btnWhatsapp.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {

String mensaje = txtMensaje.getText().toString();

Intent intent = new Intent(Intent.ACTION_VIEW);
/* //abrir app
intent.setData(Uri.parse(
"https://wa.me/?text=&quot; + Uri.encode(mensaje)));

startActivity(intent);
*/
//enviar numero especifico
intent.setData(Uri.parse(
"https://wa.me/525539059687?text=&quot;
+ Uri.encode(mensaje)));
startActivity(intent);

}
});

//CORREO
btnCorreo.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {

String mensaje = txtMensaje.getText().toString();

Intent intent = new Intent(Intent.ACTION_SEND);

intent.setType("message/rfc822");

intent.putExtra(Intent.EXTRA_SUBJECT,
"Mensaje desde mi app");

intent.putExtra(Intent.EXTRA_TEXT,
mensaje);

try {
startActivity(
Intent.createChooser(intent,
"Enviar correo"));
}
catch (Exception e) {

Toast.makeText(
MainActivity.this,
"No hay app de correo",
Toast.LENGTH_SHORT).show();
}
}
});

//SMS
btnSMS.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {

String mensaje = txtMensaje.getText().toString();

Intent intent = new Intent(
Intent.ACTION_VIEW);

intent.setData(Uri.parse("sms:"));

intent.putExtra("sms_body",
mensaje);

startActivity(intent);
}
});
}
}