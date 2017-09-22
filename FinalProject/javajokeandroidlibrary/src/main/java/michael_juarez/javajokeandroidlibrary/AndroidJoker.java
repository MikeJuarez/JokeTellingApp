package michael_juarez.javajokeandroidlibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static android.R.id.empty;

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
