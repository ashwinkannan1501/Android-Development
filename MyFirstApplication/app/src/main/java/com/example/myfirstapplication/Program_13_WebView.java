/** Android WebView :-
 ------------------------
        Android "WebView" is used to display web pages in android. The web page can be loaded from
 same application (or)URL. It used to display online content android activity. Android WebView uses
 webkit engine to display webpage.

        The "WebView" class is available inside the "android.webkit" package. The "WebView" class is
 the subclass of "AbsoluteLayout" class. You can also specify HTML string and can show it inside your
 application to a web application.

 WebView class declaration :-
 -------------------------------
    ----------------------------------------------------------------------------------------------------------------------------------------------
    | public class WebView extends AbsoluteLayout implements ViewTreeObserver, OnGlobalFocusChangeListener, ViewGroup.OnHierarchyChangeListener. |
    ----------------------------------------------------------------------------------------------------------------------------------------------

 WebView class hierarchy :-
 ----------------------------
    java.lang.Object
    ↳ android.view.View
      ↳ android.view.ViewGroup
        ↳ android.widget.AbsoluteLayout

 **/
package com.example.myfirstapplication;

// Import the necessary packages
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity; // Import "AppCompatActivity" class from the "androidx.appcompat.app" package
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout; // Import "SwipeRefreshLayout" class from the "androidx.swiperefreshlayout.widget".

import android.annotation.SuppressLint;
import android.graphics.Color; // Import the "Color" class from the "android.graphics" package
import android.os.Build; // Import the "Build" class from the "android.os" package
import android.os.Bundle; // Import the "Bundle" class from the "android.os" package
import android.webkit.WebChromeClient; // Import the "WebChromeClient" class from the "android.webkit" package.
import android.webkit.WebView; // Import the "WebView" class from the "android.webkit" package
import android.webkit.WebViewClient; // Import the "WebViewClient" class from the "android.webkit" package
import android.widget.Toast; // Import the "Toast" class from the "android.widget" package

public class Program_13_WebView extends AppCompatActivity {
    WebView websiteView;

    @RequiresApi(api = Build.VERSION_CODES.O_MR1)
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.program_13_web_view);

        WebViewClient webViewClient = new WebViewClient();

        websiteView = findViewById(R.id.website_view);
        websiteView.loadUrl("https://www.google.com"); // This method is used to loads the given URL. // https://ishani1124.github.io/FrontendBootcamp/
        websiteView.setWebViewClient(webViewClient); // This method is used to sets the WebViewClient that will receive various notifications and requests.
        websiteView.setWebChromeClient(new WebChromeClient()); // This method is used to set the chrome handler.
        websiteView.getSettings().setJavaScriptEnabled(true); // The "getSettings()" method is used to gets the WebSettings object used to control the settings for this WebView.
        websiteView.setBackgroundColor(Color.WHITE); // This method is used to set the background color for this view.
        System.out.println("zoomIn() method :- " + websiteView.zoomIn()); // This method is used to performs zoom in operations in this web view.
        System.out.println("zoomOut() method :- " + websiteView.zoomOut()); // This method is used to performs zoom out operations in this web view.

        System.out.println("getOriginalUrl() method :- " + websiteView.getOriginalUrl()); // This method is used to gets the original URL for the current page.
        System.out.println("getProgress() method :- " + websiteView.getProgress()); // This method is used to get the progress for the current page.
        System.out.println("getTextClassifier() method :- " + websiteView.getTextClassifier()); // This method used to returns the "TextClassifier" used by this web view.
        System.out.println("getTitle() method :- " + websiteView.getTitle()); // This method is used to get the title for the current page.
        System.out.println("getUrl() method :- " + websiteView.getUrl()); // This method is used to get the URL for the current page.
        System.out.println("getWebChromeClient() method :- " + websiteView.getWebChromeClient()); // This method is used to gets the chrome handler.
        System.out.println("getWebViewClient() method :- " + websiteView.getWebViewClient()); // This method is used to gets teh WebViewClient.
        System.out.println("getAccessibilityClassName() method :- " + websiteView.getAccessibilityClassName()); // This method is used to returns the class name of the object to be used for accessibility purposes.
        System.out.println("getCertificate() method :- " + websiteView.getCertificate()); // This method is used to gets the SSL certificate for the main top level page or null if there is no certificate (the site is not secure).
        System.out.println("getContentHeight() method :- " + websiteView.getContentHeight()); // This method is used to gets the height of the HTML content.
        System.out.println("getFavIcon() method :- " + websiteView.getFavicon()); // This method is used to get the favourite icon for the current page.
        System.out.println("static Uri getSafeBrowsingPrivacyPolicyUrl() method :- " + WebView.getSafeBrowsingPrivacyPolicyUrl()); // This method is used to returns the URL pointing to the privacy policy for safe browsing reporting.

        System.out.println("isPrivateBrowsingEnabled() method :- " + websiteView.isPrivateBrowsingEnabled()); // This method is used to gets whether private browsing is enabled in this WebView

        // websiteView.clearCache(true) // This method is used to clears the resource cache.
        // websiteView.clearHistory() // This method is used to clears the internal back/forward list of the web view.
        // websiteView.clearMatches() // This method is used to clears the highlighting surrounding text matches created by "findAllAsync(String)"
        // websiteView.clearSslPreferences() // This method is used to clears the SSL preferences table stored in response to proceeding with SSL certificate errors.
        // websiteView.destroy() // This method is used to destroy the internal state of this web view.
        // websiteView.pageUp(boolean top) // This method is used to scrolls the content of teh web view by half the view size.
        // websiteView.pageDown(boolean down) // This method is used to scrolls the content of the web view down by half the page size.

        int[] colorSchemes = {
                Color.BLACK, Color.BLUE, Color.GREEN, Color.RED, Color.TRANSPARENT, Color.MAGENTA,
                Color.YELLOW, Color.CYAN, Color.DKGRAY
        };
        SwipeRefreshLayout swipeDownToRefresh = findViewById(R.id.swipe_down_to_refresh);
        swipeDownToRefresh.setColorSchemeColors(colorSchemes);
        swipeDownToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                websiteView.reload();

                swipeDownToRefresh.setRefreshing(false);
            }
        });
    }

    @Override
    public void onBackPressed(){
        if(websiteView.canGoBack()){ // This method is used to checks whether this web view has a back history item and returns boolean value based on that.
            websiteView.goBack(); // This method is used to goes back in the history of this web view.
        } else {
            super.onBackPressed();
            Toast.makeText(getApplicationContext(), "There is no backward history", Toast.LENGTH_SHORT).show();
            System.exit(0);
        }
    }

}
