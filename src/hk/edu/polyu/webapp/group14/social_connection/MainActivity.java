package hk.edu.polyu.webapp.group14.social_connection;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
    public static final String host = "58.96.176.223";
    public static final int port = 9080;
    public static final String page = "nav_client.html";
    public static final String server_url = "http://" + host + ":" + port + "/" + page;
//    public static final String server_url = "http://yahoo.hk";

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initWebView();
    }

    private void initWebView() {
        WebView webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                webView.loadUrl(url);
                return false;
            }
        });
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.setNetworkAvailable(true);
        webView.loadUrl(server_url);
    }
}
