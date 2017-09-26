package com.udacity.gradle.builditbigger.paid;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.user.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

import michael_juarez.javajokeandroidlibrary.AndroidJoker;

import static michael_juarez.javajokeandroidlibrary.AndroidJoker.KEY_ANDROID_JOKE;

/**
 * Created by user on 9/25/2017.
 */

public class EndpointAsyncTask extends AsyncTask<Context, Void, String> {
    private static MyApi myApiService = null;
    private Context context;
    final private ProgressBarInterface mProgressBarInterface;


    public EndpointAsyncTask(ProgressBarInterface progressBarInterface) {
        mProgressBarInterface = progressBarInterface;
    }

    public interface ProgressBarInterface {
        void hideProgressBar(boolean hide);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mProgressBarInterface.hideProgressBar(false);
    }

    @Override
    protected String doInBackground(Context... params) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://192.168.1.92:8080/_ah/api/")
                    //.setRootUrl("10.0.2.2")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        context = params[0];

        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Intent intent = new Intent(context, AndroidJoker.class);
        intent.putExtra(KEY_ANDROID_JOKE, result);
        context.startActivity(intent);
        mProgressBarInterface.hideProgressBar(true);
    }
}