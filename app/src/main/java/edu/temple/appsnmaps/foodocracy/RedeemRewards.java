package edu.temple.appsnmaps.foodocracy;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import edu.temple.appsnmaps.foodocracy.Adapter.CustomListAdapter;

public class RedeemRewards extends Activity {
    ImageView img;
    ListView list;
    String[] itemname ={
            "Purchase/Redemption",
            "Purchase/Redemption",
            "Purchase/Redemption",
            "Purchase/Redemption",
            "Purchase/Redemption",
            "Purchase/Redemption",
            "Purchase/Redemption",
            "Purchase/Redemption"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redeem_rewards);

        CustomListAdapter adapter=new CustomListAdapter(this, itemname);
        list=(ListView)findViewById(R.id.listView);
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                String Slecteditem = itemname[+position];
                Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();

            }
        });

    }

}
