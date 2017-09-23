package michael_juarez.javajokeandroidlibrary;


import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

public class AndroidJoker extends AppCompatActivity {
    public final static String KEY_ANDROID_JOKE = "michael.juarez.javajokeandroidlibrary.keyandroidjoke";

    private String theJoke;
    private TextView mAndroidJokeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_joker);

        //I know about ButterKnife, just wanted to refresh my skills on the manual way
        mAndroidJokeTextView = (TextView) findViewById(R.id.android_joker_tv);
        theJoke = getIntent().getStringExtra(KEY_ANDROID_JOKE);

        if (theJoke != null && theJoke.length() != 0)
            mAndroidJokeTextView.setText(theJoke);
        else
            mAndroidJokeTextView.setText(R.string.empty_joke);


    }
}
