package com.udacity.gradle.builditbigger.paid;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.user.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.R;
import com.udacity.gradle.builditbigger.paid.EndpointAsyncTask;

import java.io.IOException;

import michael_juarez.javajokeandroidlibrary.AndroidJoker;

import static michael_juarez.javajokeandroidlibrary.AndroidJoker.KEY_ANDROID_JOKE;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements EndpointAsyncTask.ProgressBarInterface {
    private Button mTellJokeButton;
    private ProgressBar mProgressSpinner;
    private TextView mInstructionsTextView;
    private AsyncTask mEndpointAsyncTask;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        mTellJokeButton = (Button) root.findViewById(R.id.main_tell_joke_button);
        mProgressSpinner = (ProgressBar) root.findViewById(R.id.progressBar1);
        mInstructionsTextView = (TextView) root.findViewById(R.id.instructions_text_view);

        mTellJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tellJoke(v);
            }
        });

        return root;
    }

    public void tellJoke(View view) {
        mEndpointAsyncTask = new EndpointAsyncTask(this).execute(getActivity());
    }

    private void showProgressBar() {
        mTellJokeButton.setVisibility(View.INVISIBLE);
        mInstructionsTextView.setVisibility(View.INVISIBLE);
        mProgressSpinner.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mTellJokeButton.setVisibility(View.VISIBLE);
        mInstructionsTextView.setVisibility(View.VISIBLE);
        mProgressSpinner.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgressBar(boolean hide) {
        if (hide)
            hideProgressBar();
        else
            showProgressBar();
    }

    @Override
    public void onPause() {
        mEndpointAsyncTask.cancel(true);
        super.onPause();
    }
}
