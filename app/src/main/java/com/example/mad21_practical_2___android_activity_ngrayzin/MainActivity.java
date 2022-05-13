package com.example.mad21_practical_2___android_activity_ngrayzin;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import java.util.EventListener;


public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent mIntent = getIntent();
        String Value = mIntent.getStringExtra("name");
        String Value2 = mIntent.getStringExtra("des");
        Boolean follow = getIntent().getExtras().getBoolean("follow");
        TextView tv1 = (TextView)findViewById(R.id.textView);
        TextView tv2 = (TextView)findViewById(R.id.textView2);
        tv1.setText(Value);
        tv2.setText(Value2);
        User user = new User(Value,Value2,0,follow);
        followfunction(user);
    }




    public void followfunction(User user)
    {
        Button button = (Button)findViewById(R.id.button2);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.followed = !user.followed;
                button.setText(user.followed ? "UNFOLLOW": "FOLLOW");
                Toast.makeText(MainActivity.this, user.followed ?"Followed" : "Unfollowed", Toast.LENGTH_SHORT).show();
            }
        };
        button.setOnClickListener(listener);

    }

    public void messagefunction(View view)
    {
        Intent activityName = new Intent(MainActivity.this,MessageGroup.class);
        startActivity(activityName);
    }


}