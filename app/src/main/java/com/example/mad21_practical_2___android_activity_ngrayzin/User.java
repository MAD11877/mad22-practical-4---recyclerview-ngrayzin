package com.example.mad21_practical_2___android_activity_ngrayzin;

import android.icu.lang.UProperty;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class User {

    public String name;
    public String description;
    public Integer id;
    public Boolean followed;

    public User(String n, String d, Integer id, Boolean f){
        name = n;
        description = d;
        this.id = id;
        followed = f;
    }
}


