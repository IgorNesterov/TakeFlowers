package com.example.takeflowers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{
    //private boolean flag;
    public Button toShops_button = null;
    public Button login_button = null;
    public EditText mail = null;
    public EditText password = null;
    public Switch lang_switch = null;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main);

        login_button = (Button) findViewById(R.id.loginButon);
        password = (EditText) findViewById(R.id.password);
        mail = (EditText) findViewById(R.id.mail);
        toShops_button = (Button) findViewById(R.id.toShops_button);

        lang_switch = (Switch) findViewById(R.id.lang_switch);
        lang_switch.setOnCheckedChangeListener(this);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);

        //Button toShops_button = (Button)findViewById(R.id.toShops_button);
        //toShops_button.setOnClickListener(this);
    }

    public void updateUI(FirebaseUser in){
        if(in != null){
            toShops_button.setEnabled(true);
            login_button.setVisibility(View.INVISIBLE);
            password.setVisibility(View.INVISIBLE);
            mail.setVisibility(View.INVISIBLE);
            toShops_button.setVisibility(View.VISIBLE);;
        }
        else{
            login_button.setVisibility(View.VISIBLE);
            password.setVisibility(View.VISIBLE);
            mail.setVisibility(View.VISIBLE);
            toShops_button.setVisibility(View.INVISIBLE);;
        }
    }
    //@Override
    public void onShopsClick(View view) {
        Intent i;
        //i = new Intent(this, ListShops.class);
        i = new Intent(this, ListShops.class);
        startActivity(i);
    }
    public void onLoginClick(View view) {
        mAuth.signInWithEmailAndPassword(mail.getText().toString(), password.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            //Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            //Log.w(TAG, "signInWithEmail:failure", task.getException());
                            //Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
                                    //Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // ...
                    }
                });

    }
    public void onExitClick(View view) {
        finish();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        //Locale locale;
        if (isChecked) {
            //locale = new Locale("ru");
            //exit_button.setText("Exit");
            toShops_button.setText("Change shop");
            lang_switch.setText("English");
        } else {
            //locale = new Locale("en");
            //exit_button.setText("Выход");
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
