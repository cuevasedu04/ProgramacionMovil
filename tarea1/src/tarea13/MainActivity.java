package tarea13;

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
        webview.loadUrl("https://pw1515-36409.web.app");
    }
}
