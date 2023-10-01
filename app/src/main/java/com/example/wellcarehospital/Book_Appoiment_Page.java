package com.example.wellcarehospital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Book_Appoiment_Page extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appoiment_page);
        List<appoiment_data> list = new ArrayList<>();
        list = getData();
        recyclerView = (RecyclerView)findViewById(
                R.id.recyclerView);

    }

    private List<appoiment_data> getData()
    {
        List<appoiment_data> list = new ArrayList<>();
        list.add(new appoiment_data("First Exam",
                "May 23, 2015",
                "Best Of Luck"));
        list.add(new appoiment_data("Second Exam",
                "June 09, 2015",
                "b of l"));
        list.add(new appoiment_data("My Test Exam",
                "April 27, 2017",
                "This is testing exam .."));

        return list;
    }


}