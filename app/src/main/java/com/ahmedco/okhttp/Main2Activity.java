package com.ahmedco.okhttp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import okhttp3.Authenticator;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.logging.HttpLoggingInterceptor;


//https://blog.codavel.com/how-to-create-an-http-interceptor-for-an-android-app-using-okhttp3
public class Main2Activity extends AppCompatActivity {

    private String TAG = Main2Activity.class.getSimpleName();
    private OkHttpClient client;
    private Call call;
    private Spinner coupnCategories;

    /**
     * OkHttp client to perform HTTP requests
     */
    private OkHttpClient okHttpClient;

    /**
     * WebView to present the result
     */
    private WebView webView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // spinner to be populated with coupon categories from rest service
        // coupnCategories = (Spinner) findViewById(R.id.cpn_cats_spn);
        setOnClickListeners();
    }

      /**
     * Defines the click listeners and respective behaviour.
     * "Go" button will inflate the UI WebView with the result of the Http response.
     * Interceptor switch will redefine the OkHttp client to enable/disable the interceptor.
     */

    private void setOnClickListeners(){

        Switch aSwitch=(Switch)findViewById(R.id.switch1);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView , boolean isChecked){

                Log.i("TRACE0","" + isChecked);

                if (isChecked) {

                    okHttpClient = new OkHttpClient().newBuilder().addInterceptor(new InterceptRequest()).build();

                } else {

                    okHttpClient = new OkHttpClient().newBuilder().build();

                }
            }
        });


        Button aButton = (Button) findViewById(R.id.button);

        aButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                webView = (WebView) findViewById(R.id.webView);
                webView.setWebViewClient(createOkhttpClient());
                webView.loadUrl("https://m.media-amazon.com/images/M/MV5BNGNhMDIzZTUtNTBlZi00MTRlLWFjM2ItYzViMjE3YzI5MjljXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_UY268_CR1,0,182,268_AL_.jpg");
            }
        });
    }

    /**
     * Creates a WebViewClient that uses OkhttpClient to perform requests.
     *
     * @return WebViewClient with an OkhttpClient
     */

    private WebViewClient createOkhttpClient(){

        System.out.println("CREATE CLIENT");

        return new WebViewClient(){

            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, String url) {

                System.out.println("NEW RESOURCE RESPONSE");
                Request okHttpRequest = new Request.Builder().url(url).cacheControl(CacheControl.FORCE_NETWORK).build();

                try {

                    Response response = okHttpClient.newCall(okHttpRequest).execute();
                    System.out.println(response.code());
                    WebResourceResponse webResource = new WebResourceResponse("", "", response.body().byteStream());


                    return webResource;
                } catch (IOException e){
                    e.printStackTrace();
                }
                return null;
            }
        };
    }
}










