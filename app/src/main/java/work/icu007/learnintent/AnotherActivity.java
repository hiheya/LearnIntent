package work.icu007.learnintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AnotherActivity extends AppCompatActivity {

    public static final String ACTION = "work.icu007.learnintent.AnotherActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
    }
}