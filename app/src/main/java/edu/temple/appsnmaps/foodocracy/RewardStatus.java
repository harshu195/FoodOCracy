package edu.temple.appsnmaps.foodocracy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import edu.temple.appsnmaps.foodocracy.Adapter.RewardStatusAdapter;
import edu.temple.appsnmaps.foodocracy.Classes.Food;

public class RewardStatus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reward_status);
        Food food_data[] = new Food[]{
                new Food(R.drawable.starbucks, "Starbucks", "312 points"),
                new Food(R.drawable.wendy, "Wendy's", "110 points"),
                new Food(R.drawable.olive, "Olive Garden", "376 points"),
                new Food(R.drawable.hut, "Pizza Hut", "325 points"),
                new Food(R.drawable.sub, "Subway", "55 points"),
                new Food(R.drawable.king, "Burger King", "19 points")
        };
        RewardStatusAdapter adapter = new RewardStatusAdapter(this, R.layout.format_reward_status, food_data);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(RewardStatus.this, RedeemRewards.class);
                startActivity(i);
                finish();
            }
        });

    }
}
