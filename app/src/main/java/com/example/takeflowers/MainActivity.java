package com.example.takeflowers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
}
