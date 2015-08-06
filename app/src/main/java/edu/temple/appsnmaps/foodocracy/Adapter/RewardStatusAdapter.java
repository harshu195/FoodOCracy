package edu.temple.appsnmaps.foodocracy.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import edu.temple.appsnmaps.foodocracy.Classes.Food;
import edu.temple.appsnmaps.foodocracy.R;

public class RewardStatusAdapter extends ArrayAdapter<Food>{

    Context c;
    int layoutResourceId;
    Food data[] = null;

    public RewardStatusAdapter(Context c, int layoutResourceId, Food[] data){
        super(c,layoutResourceId,data);
        this.c=c;
        this.data=data;
        this.layoutResourceId=layoutResourceId;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        FoodHolder holder = null;

        if (row == null)
        {
            LayoutInflater inflater = ((Activity)c).getLayoutInflater();
            row = inflater.inflate(layoutResourceId,parent,false);

            holder = new FoodHolder();
            holder.logo = (ImageButton)row.findViewById(R.id.ibtnLogo);
            holder.pts = (TextView)row.findViewById(R.id.tvPts);
            holder.foodname = (TextView)row.findViewById(R.id.tvFoodname);

            row.setTag(holder);
        }
        else {
            holder = (FoodHolder) row.getTag();
        }
        Food food = data[position];
        holder.foodname.setText(food.place);
        holder.pts.setText(food.points);
        holder.logo.setImageResource(food.icon);

        return row;
    }


    static class FoodHolder
    {
        ImageButton logo;
        TextView pts;
        TextView foodname;
    }
}
