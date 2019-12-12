package com.example.takeflowers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{
    //private boolean flag;
    public Button exit_button = null;
    public Button toShops_button = null;
    public Switch lang_switch = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exit_button = (Button) findViewById(R.id.exit_button);
        toShops_button = (Button) findViewById(R.id.toShops_button);

        lang_switch = (Switch) findViewById(R.id.lang_switch);
        lang_switch.setOnCheckedChangeListener(this);


        //Button toShops_button = (Button)findViewById(R.id.toShops_button);
        //toShops_button.setOnClickListener(this);
    }

    //@Override
    public void onShopsClick(View view) {
        Intent i;

        i = new Intent(this, ListShops.class);
        startActivity(i);
    }
    public void onExitClick(View view) {
        finish();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        //Locale locale;
        if (isChecked) {
            //locale = new Locale("ru");
            exit_button.setText("Exit");
            toShops_button.setText("Change shop");
            lang_switch.setText("English");
        } else {
            //locale = new Locale("en");
            exit_button.setText("Выход");
            toShops_button.setText("Выбрать магазин");
            lang_switch.setText("Русский");
        }
/*
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getBaseContext().getResources().updateConfiguration(configuration, null);
        exit_button.setText(R.string.ex);
        toShops_button.setText(R.string.get_shops);
        lang_switch.setText(R.string.lang);
        exit_button.refreshDrawableState();*/
    }
}
