package com.andreysc.hw2_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class PropertyActivity extends AppCompatActivity {
    public static final String THEME_DARK="THEME_DARK";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);

        int activeTheme = getIntent().getExtras().getInt(MainActivity.PREF_THEME);
        SwitchMaterial tbSwitch = findViewById(R.id.switchTheme);
        if (activeTheme == MainActivity.NIGHT_THEME){
            tbSwitch.setChecked(true);
        } else {
            tbSwitch.setChecked(false);
        }

        findViewById(R.id.buttonApply).setOnClickListener(v -> {
            Intent intentResult = new Intent();
            SwitchMaterial tb =findViewById(R.id.switchTheme);
            int theme;
            if (tb.isChecked()){
                theme = MainActivity.NIGHT_THEME;
            } else {
                theme = MainActivity.DAY_THEME;
            }
            intentResult.putExtra(MainActivity.PREF_THEME,theme);
            setResult(20,intentResult);
            finish();
        });
    }
}