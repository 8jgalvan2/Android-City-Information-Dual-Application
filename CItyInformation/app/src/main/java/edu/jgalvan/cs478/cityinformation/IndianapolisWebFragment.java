package edu.jgalvan.cs478.cityinformation;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Jonathan on 3/16/16.
 */
public class IndianapolisWebFragment extends Fragment {

    private String currentUrl;

    // Method that will update the private variable of the webview object
    public void init(String webUrl) {

        currentUrl = webUrl;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    // Inflates the the webpage layout
    // In addition the following url is loaded and display the
    // webpage that correlates with the location pressed

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.indianapolis_web,container,false);

        WebView webView = (WebView) view.findViewById(R.id.indianapolisWeb);

        webView.loadUrl(currentUrl);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        return view;
    }

}