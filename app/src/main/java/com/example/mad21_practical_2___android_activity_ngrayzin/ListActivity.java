package com.example.mad21_practical_2___android_activity_ngrayzin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ListActivity extends AppCompatActivity /*implements adapter.OnNoteListener*/ {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        trash();

        /*View btn = findViewById(R.id.imageView2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createalertdialog();
            }
        });*/


    }
    public void trash(){
        ArrayList<User> people = new ArrayList<>();
        for(int i = 0; i < 20; i++){
            User person = new User("Name" + randomnum(), "Description " + randomnum(), i, (Math.random() < 0.5));
            people.add(person);
        }
        RecyclerView rv = findViewById(R.id.recyclerview);
        adapter aDapter = new adapter(people/*, this::onNoteClick*/);
        LinearLayoutManager layout = new LinearLayoutManager(this);
        rv.setLayoutManager(layout);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(aDapter);
    }
    public Integer randomnum(){
        int num = (int) Math.round(Math.random() * 1000000);
        return num;
    }



    /*public void createalertdialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Profile");
        builder.setMessage("idkhowdolah cb dog");
        builder.setCancelable(true);
        builder.setPositiveButton(
                "VIEW", new
                        DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int id){
                                int nxt = (int) Math.round(Math.random() * 1000000);
                                Intent activityName = new Intent(ListActivity.this,MainActivity.class);
                                activityName.putExtra("Random", nxt);
                                startActivity(activityName);

                            }
                        });
        builder.setNegativeButton("CLOSE", new
                DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        dialog.cancel();

                    }
                });
        AlertDialog alert11 = builder.create();
        alert11.show();
    }


    public interface onitemclicklistener{
        public void onclick(View view, int position);
    }*/
}