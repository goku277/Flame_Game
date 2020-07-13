package com.example.flame_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.media.MediaPlayer;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button click;
    private EditText t1,t11;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(this, R.raw.button_2_sound);
        t1= (EditText) findViewById(R.id.editText);
        t11= (EditText) findViewById(R.id.editText2);
        click= (Button) findViewById(R.id.clickMe);
        click.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.clickMe:
               Start();
                String myName= t1.getText().toString(), friendsName= t11.getText().toString();
                if (myName.length()==0 || friendsName.length()==0) Toast.makeText(this,"Please fill the text fields to process throgh", Toast.LENGTH_LONG).show();
                else {
                    Intent intent = new Intent(MainActivity.this, result.class);
                    intent.putExtra("myname", myName);
                    intent.putExtra("friendname", friendsName);
                    startActivity(intent);
                    finish();
                }
        }
    }
    private void Start() {
        mediaPlayer.start();
        Thread t1= new Thread();
        try {
            t1.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}