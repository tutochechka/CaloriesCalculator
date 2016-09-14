package com.gazina.sveta.caloriescalculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

public class CalculatorActivity extends Activity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
//        expListView.setOnGroupClickListener(new OnGroupClickListener() {
//
//            @Override
//            public boolean onGroupClick(ExpandableListView parent, View v,
//                                        int groupPosition, long id) {
//                // Toast.makeText(getApplicationContext(),
//                // "Group Clicked " + listDataHeader.get(groupPosition),
//                // Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        });

        expListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getApplicationContext(),
                         "Added : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Meat");
        listDataHeader.add("Fish");
        listDataHeader.add("Grains");
        listDataHeader.add("Fruits");
        listDataHeader.add("Vegetables");
        listDataHeader.add("Liquids");
        listDataHeader.add("Other");

        // Adding child data
        List<String> meat = new ArrayList<String>();
        meat.add("Pork");
        meat.add("Beef");
        meat.add("Chicken");
        meat.add("Sausages");
        meat.add("Salami");
        meat.add("Bacon");

        List<String> fish = new ArrayList<String>();
        fish.add("Salmon");
        fish.add("Makrel");
        fish.add("Shrimp");


        List<String> grains = new ArrayList<String>();
        grains.add("Wheat");
        grains.add("Rice");
        grains.add("Buckwheat");
        grains.add("Bulgur");

        List<String> fruits = new ArrayList<String>();
        fruits.add("Strawberry");
        fruits.add("Blackberry");
        fruits.add("Orange");
        fruits.add("Lemon");
        fruits.add("Apple");
        fruits.add("Pineapple");
        fruits.add("Raspberry");
        fruits.add("Cherry");
        fruits.add("Pear");
        fruits.add("Mango");

        List<String> vegetables = new ArrayList<String>();
        vegetables.add("Cucumber");
        vegetables.add("Salad");
        vegetables.add("Tomato");
        vegetables.add("Potato");
        vegetables.add("Onion");
        vegetables.add("Peas");
        vegetables.add("Beet");
        vegetables.add("Carrot");
        vegetables.add("Cabbage");
        vegetables.add("Broccoli");
        vegetables.add("Asparagus");
        vegetables.add("Eggplant");
        vegetables.add("Pumpkin");

        List<String> liquids = new ArrayList<String>();
        liquids.add("Water");
        liquids.add("Milk");
        liquids.add("Juise");
        liquids.add("Cream");
        liquids.add("Sourcream");

        List<String> other = new ArrayList<String>();
        other.add("Pasta");
        other.add("Egg");
        other.add("Flour");
        other.add("Mayo");


        listDataChild.put(listDataHeader.get(0), meat); // Header, Child data
        listDataChild.put(listDataHeader.get(1), fish);
        listDataChild.put(listDataHeader.get(2), grains);
        listDataChild.put(listDataHeader.get(3), fruits);
        listDataChild.put(listDataHeader.get(4), vegetables);
        listDataChild.put(listDataHeader.get(5), liquids);
        listDataChild.put(listDataHeader.get(6), other);

    }
}
