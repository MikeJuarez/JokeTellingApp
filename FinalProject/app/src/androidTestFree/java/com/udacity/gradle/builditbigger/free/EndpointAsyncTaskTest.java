package com.udacity.gradle.builditbigger.free;

import android.support.test.rule.ActivityTestRule;

import com.google.android.gms.ads.InterstitialAd;
import com.udacity.gradle.builditbigger.MainActivity;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

/**
 * Created by user on 9/25/2017.
 */
public class EndpointAsyncTaskTest  implements EndpointAsyncTask.ProgressBarInterface {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule
            = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testAsync() {
        String result = null;

        final EndpointAsyncTask endpointAsyncTask = new EndpointAsyncTask(this, new InterstitialAd(mActivityTestRule.getActivity()));

        endpointAsyncTask.execute(mActivityTestRule.getActivity());

        try {
            result = endpointAsyncTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(result.length() > 0 && !result.equals("connect timed out"));
    }

    @Override
    public void hideProgressBar(boolean hide) {}
}