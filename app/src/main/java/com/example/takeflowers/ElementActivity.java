package com.example.takeflowers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ElementActivity extends AppCompatActivity {
    TextView adreesValue;
    TextView adreesLabel;
    TextView telephoneValue;
    TextView telephoneLabel;
    TextView nameValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element);


        MyDBHelper db = new MyDBHelper(this);
        db.createDefaultShopsIfNeed();
        String par = getIntent().getStringExtra("name");
        Shop shop =  db.getShop(par);

        adreesValue = findViewById(R.id.addressText);
        adreesLabel = findViewById(R.id.addressLabel);
        telephoneValue = findViewById(R.id.telephoneText);
        telephoneLabel = findViewById(R.id.telephoneLabel);
        nameValue = findViewById(R.id.nameText);

        adreesLabel.setText(R.string.address);
        telephoneLabel.setText(R.string.telephone);

        adreesValue.setText(shop.getShopAddress());
        telephoneValue.setText(shop.getShopTelephone());
        nameValue.setText(shop.getShopName());

    }

    public void onCallClick(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+telephoneValue));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
