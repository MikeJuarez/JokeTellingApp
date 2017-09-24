package com.udacity.gradle.builditbigger;

/**
 * Created by user on 9/23/2017.
 */

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.udacity.builditbigger.free.MainActivity;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

@RunWith(AndroidJUnit4.class)
public class JokeIsNonEmptyTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule
            = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testAsync() {
        String result = null;

        final EndpointAsyncTask endpointAsyncTask = new EndpointAsyncTask();

        endpointAsyncTask.execute(mActivityTestRule.getActivity());

        try {
            result = endpointAsyncTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(result.length() > 0);
    }
}
