package com.udacity.builditbigger.free;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.udacity.gradle.builditbigger.R;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private Button mTellJokeButton;
    private InterstitialAd mInterstitialAd;
    private AdView mAdView;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        mAdView = (AdView) root.findViewById(R.id.adView);
        mTellJokeButton = (Button) root.findViewById(R.id.main_tell_joke_button);

        setUpAds();
        return root;
    }

    public void setUpAds() {
        String adUnitId = getActivity().getResources().getString(R.string.banner_ad_unit_id);
        String deviceID = getActivity().getResources().getString(R.string.device_id);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        //Interstitial Ad
        AdRequest adRequest2 = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice(deviceID)
                .build();

        mInterstitialAd = new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId(adUnitId);
        mInterstitialAd.loadAd(adRequest2);

        mTellJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tellJoke(v);
            }
        });
    }

    public void tellJoke(View view) {
        new EndpointAsyncTask(mInterstitialAd).execute(getActivity());
    }

    public void onResume() {
        super.onResume();
        setUpAds();
    }


}
