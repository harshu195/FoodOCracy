package edu.temple.appsnmaps.foodocracy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import edu.temple.appsnmaps.foodocracy.Adapter.RewardStatusAdapter;
import edu.temple.appsnmaps.foodocracy.Classes.Food;

public class RewardStatus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reward_status);
        Food food_data[] = new Food[]{
                new Food(R.drawable.starbucks, "Starbucks", "312 points"),
                new Food(R.drawable.da, "Wendy's", "110 points"),
                new Food(R.drawable.da, "Olive Garden", "376 points"),
                new Food(R.drawable.da, "Pizza Hut", "325 points"),
                new Food(R.drawable.da, "Subway", "55 points"),
                new Food(R.drawable.da, "Burger King", "19 points")
        };
        RewardStatusAdapter adapter = new RewardStatusAdapter(this, R.layout.format_reward_status, food_data);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
}
