package com.example.homework1314;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.View;

import com.example.homework1314.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.button.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        Intent intent;
        Log.v("START PROV","CLICK PROV");
        switch (view.getId()){
            case R.id.button:
                Log.v("TEST GET TEXT",binding.login.getText().toString()+" "+ binding.password.getText().toString());
                if(binding.login.getText().toString().equals("rickroll@gmail.com") && binding.password.getText().toString().equals("RickAstley")){
                    Log.v("HELLOENG","Hi,Rickroll");
                    binding.error.setText("");
                    intent=new Intent(MainActivity.this,ProfileActivity.class);
                    intent.putExtra("LoginText",binding.login.getText().toString());
                    startActivity(intent);
                    finish();
                }
                else{
                    binding.error.setText("Неверный логин или пароль");
                    Log.v("ERRORMOMENT","error login or password");
                }
                break;
        }
    }
}