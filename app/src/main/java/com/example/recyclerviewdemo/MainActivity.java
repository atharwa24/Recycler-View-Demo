package com.example.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClicked {

    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<Person> people;

    Button btnAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);

        btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                people.add(new Person("John","kim","bus"));
                myAdapter.notifyDataSetChanged();

            }
        });

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        people = new ArrayList<Person>();
        people.add(new Person("John","kim","bus"));
        people.add(new Person("hua","lok","plane"));
        people.add(new Person("dos","hua","bus"));
        people.add(new Person("John","kim","bus"));
        people.add(new Person("hua","lok","plane"));
        people.add(new Person("dos","hua","bus"));
        people.add(new Person("John","kim","bus"));
        people.add(new Person("hua","lok","plane"));
        people.add(new Person("dos","hua","bus"));

        myAdapter = new PersonAdapter(this, people);

        recyclerView.setAdapter(myAdapter);

    }

    @Override
    public void onItemClicked(int index)
    {
        Toast.makeText(this, "Surname" + people.get(index).getSurname(), Toast.LENGTH_SHORT).show();

    }
}