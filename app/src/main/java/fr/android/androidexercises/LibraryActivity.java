package fr.android.androidexercises;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class LibraryActivity extends AppCompatActivity implements Step0Fragment.OnNextStep0Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        boolean landscape = getResources().getBoolean(R.bool.landscape);

        View fragment1 = findViewById(R.id.fragment1);

        if (landscape) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment1, new Step0Fragment())
                    .commit();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment2, new Step1Fragment())
                    .commit();
            fragment1.setVisibility(View.VISIBLE);
        } else {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment1, new Step0Fragment())
                    .commit();
            fragment1.setVisibility(View.GONE);
        }

    }

    @Override
    public void onNext() {

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment2, new Step1Fragment(), Step1Fragment.class.getSimpleName())
                .addToBackStack(Step1Fragment.class.getSimpleName())
                .commit();
    }

}