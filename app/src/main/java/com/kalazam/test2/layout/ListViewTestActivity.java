package com.kalazam.test2.layout;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.kalazam.test2.R;
import com.kalazam.test2.adapter.FruitAdapter;
import com.kalazam.test2.adapter.FruitAdapter1;
import com.kalazam.test2.entity.Fruit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListViewTestActivity extends AppCompatActivity {

//    private String[] data = {"apple","banana","orange","apple","banana","apple","banana","apple","banana","apple","banana","apple","banana","apple","banana","apple","banana","apple","banana","apple","banana","apple","banana",};
    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_test);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }
        //ListView实现
        /**
        initFruit();
        FruitAdapter adapter = new FruitAdapter(ListViewTestActivity.this,R.layout.fruit_item,fruitList);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(ListViewTestActivity.this,fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
         */

        //RecyclerView实现
        initFruit();
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);


        //横向布局
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        //瀑布布局
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter1 adapter1 = new FruitAdapter1(fruitList);
        recyclerView.setAdapter(adapter1);

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListViewTestActivity.this,android.R.layout.simple_list_item_1,data);
//            ListView listView = (ListView) findViewById(R.id.list_view);
//            listView.setAdapter(adapter);
    }
    private void initFruit(){
        for (int i = 0; i < 10;i++){
            Fruit apple = new Fruit(getRomdomLengthName("Apple")+i,R.drawable.edit);
            fruitList.add(apple);

            Fruit banana = new Fruit(getRomdomLengthName("banana")+i,R.drawable.edit);
            fruitList.add(banana);

            Fruit orange = new Fruit(getRomdomLengthName("orange")+i,R.drawable.edit);
            fruitList.add(orange);

            Fruit pear = new Fruit(getRomdomLengthName("pear")+i,R.drawable.edit);
            fruitList.add(pear);
        }
    }

    private String getRomdomLengthName(String name){
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0;i < length;i++){
            stringBuilder.append(name);
        }
        return stringBuilder.toString();
    }
}
