package com.example.flame_game;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Path;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class result extends AppCompatActivity implements View.OnClickListener {
    private TextView t1;
    private ImageView angel_boy, smiley_spects, power;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        mediaPlayer = MediaPlayer.create(this, R.raw.mechanical_laugh);
        t1= (TextView) findViewById(R.id.resultId);
        angel_boy= (ImageView) findViewById(R.id.angel_id);
        smiley_spects=(ImageView) findViewById(R.id.faceId);
        power= (ImageView) findViewById(R.id.powerId);
        power.setOnClickListener(this);
        getDetails();
        Thread t1= new Thread();
        try {
            t1.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mediaPlayer.start();
    }
    private void getDetails() {
        Intent intent= new Intent();
        String myName= getIntent().getStringExtra("myname");
        String friendName= getIntent().getStringExtra("friendname");
        System.out.println(myName + " " + friendName);
        calculateFlame(myName,friendName);
    }
    private void calculateFlame(String myName, String friendName) {
        ArrayList<String> name= new ArrayList<>();
        ArrayList<String> copy_name= new ArrayList<>();
        for (int i=0;i<myName.length();i++) name.add(String.valueOf(myName.charAt(i)).toUpperCase());
        copy_name.addAll(name);
        System.out.println("Enter your friend's name:");
        ArrayList<String> friend= new ArrayList<>();
        ArrayList<String> copy_friend= new ArrayList<>();
        for (int i=0;i<friendName.length();i++) friend.add(String.valueOf(friendName.charAt(i)).toUpperCase());
        copy_friend.addAll(friend);
        name.removeAll(friend);
        copy_friend.removeAll(copy_name);
        System.out.println(myName + " " + friendName);
        System.out.println(name + " " + copy_friend);
        int len= name.size() + copy_friend.size(), i1=1;
        ArrayList<String> FLAME= new ArrayList<>();
        FLAME.add("F");   // Friend
        FLAME.add("L");  // Love
        FLAME.add("A"); // Affection
        FLAME.add("M");//  Marry
        FLAME.add("E");//  Enemy
        Map<String,String> map1= new HashMap<>();
        map1.put("F","Friend");
        map1.put("L","Lover");
        map1.put("A","Affectionate one");
        map1.put("M","Wife");
        map1.put("E","Enemy");
        while (FLAME.size()>1) {
            int index=0;
            for (int i=0;i<len;i++) index= i%(FLAME.size());
            FLAME.remove(index);
            System.out.print(FLAME + " ");
        }
       t1.setText(friendName + " " + "is your" + " " + map1.get(FLAME.get(0)));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Path path = new Path();
        //    path.arcTo(0f, 0f, 1000f, 10f, 270f, -180f, true);
            angel_boy.setVisibility(View.VISIBLE);
            path.addRect(1000,0,1,0, Path.Direction.CCW);
            ObjectAnimator animator = ObjectAnimator.ofFloat(angel_boy, angel_boy.X, angel_boy.Y, path);
            animator.setDuration(5000);
            animator.start();
        } else {
            // Create animator without using curved path
        }
    }
    @Override
    public void onClick(View view) {
        finish();
        System.exit(0);
    }
}