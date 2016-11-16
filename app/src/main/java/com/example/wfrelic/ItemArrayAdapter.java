package com.example.wfrelic;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hackeru on 16/11/2016.
 */
public class ItemArrayAdapter extends ArrayAdapter<Item> {

    ArrayList<Item> items;
    Activity activity;

    public ItemArrayAdapter(Activity activity, ArrayList<Item> items) {

        super(activity, R.layout.item_cell, R.id.lblName, items);
        this.items = items;
        this.activity = activity;
    }

    static class ViewContainer {
        TextView lblName;
        TextView lblDucats;
        TextView lblPlat;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewContainer viewContainer;
        View rowView = convertView;
        if(rowView == null){
            LayoutInflater inflater = activity.getLayoutInflater();
            rowView = inflater.inflate(R.layout.item_cell, null);
            viewContainer = new ViewContainer();
            viewContainer.lblName = (TextView)rowView.findViewById(R.id.lblName);
            viewContainer.lblDucats = (TextView)rowView.findViewById(R.id.lblDucats);
            viewContainer.lblPlat = (TextView)rowView.findViewById(R.id.lblPlat);
            rowView.setTag(viewContainer);
        }else{
            viewContainer = (ViewContainer)rowView.getTag();
        }
        viewContainer.lblName.setText(items.get(position).getName() + " " + items.get(position).getPart());
        viewContainer.lblDucats.setText(items.get(position).getDucat() + " Ducats");
        viewContainer.lblPlat.setText((items.get(position).getPlat() == -1) ? "Unknown" : items.get(position).getPlat() + " Plat");
        return  rowView;

    }
}
