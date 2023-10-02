//package com.example.wellcarehospital;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Adapter;
//import android.widget.AdapterView;
//
//import java.util.ArrayList;
//
//public class customlistview extends AppCompatActivity {
//
//    ActivityMainBinding binding;
//    ListAdapter listAdapter;
//    ArrayList<ListData> dataArrayList = new ArrayList<>();
//    ListData listData;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        int[] imageList = {R.drawable.doc2, R.drawable.doc2};
//        int[] imgredientList = {R.string.pastaIngredients};
//        int[] descList = {R.string.pastaDesc};
//        String[] nameList = {"Pasta","Maggi"};
//        String[] timeList = {"30 mins"};
//
//        for (int i = 0; i < imageList.length; i++){
//            listData = new ListData(nameList[i], timeList[i], ingredientsList[i],descList[i], imageList[i]);
//            dataArrayList.add(listData);
//        }
//        listAdapter = new ListAdapter(MainActivity.this, dataArrayList);
//        binding.listview.setAdapter(listAdapter);
//        binding.listview.setClickable(true);
//
//        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
//                Integer intent = new Intent(MainActivity.this, DetailedActivity.class);
//                intent.putExtra("name", nameList[i]);
//                intent.putExtra("time", timeList[i]);
//                intent.putExtra("ingredients", ingredientList[i]);
//                intent.putExtra("desc", descList[i]);
//                intent.putExtra("image", imageList[i]);
//                startActivity(intent);
//            }
//        });
//    }
//}