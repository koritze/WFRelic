package com.example.wfrelic;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hackeru on 16/11/2016.
 */
public class ItemArrayAdapter extends ArrayAdapter<Item> implements Filterable {

    ArrayList<Item> items;
    ArrayList<Item> filteredItems;
    Activity activity;

    public ItemArrayAdapter(Activity activity, ArrayList<Item> items) {

        super(activity, R.layout.item_cell, R.id.lblName, items);
        this.items = items;
        this.filteredItems = items;
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

        /*viewContainer.lblName.setText(items.get(position).getName() + " " + items.get(position).getPart());
        viewContainer.lblDucats.setText(String.valueOf(items.get(position).getDucat()));
        viewContainer.lblPlat.setText((items.get(position).getPlat() == -1) ? "N/A" : String.valueOf(items.get(position).getPlat()));*/

        if (position >= filteredItems.size())
        {

            viewContainer.lblName.setText("BUG");
            viewContainer.lblDucats.setText("BUG");
            viewContainer.lblPlat.setText("BUG");
        }
        else {
            viewContainer.lblName.setText(filteredItems.get(position).getName() + " " + filteredItems.get(position).getPart());
            viewContainer.lblDucats.setText(String.valueOf(filteredItems.get(position).getDucat()));
            viewContainer.lblPlat.setText((filteredItems.get(position).getPlat() == -1) ? "N/A" : String.valueOf(filteredItems.get(position).getPlat()));
        }

        return  rowView;

    }

    @Override
    public Filter getFilter()
    {
        return new Filter()
        {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence)
            {
                FilterResults results = new FilterResults();

                //If there's nothing to filter on, return the original data for your list
                if(charSequence == null || charSequence.length() == 0)
                {
                    results.values = items;
                    results.count = items.size();
                }
                else
                {
                    ArrayList<Item> filterResultsData = new ArrayList();

                    String toCompare = String.valueOf(charSequence).toLowerCase();

                    for(Item data : items)
                    {
                        //In this loop, you'll filter through originalData and compare each item to charSequence.
                        //If you find a match, add it to your new ArrayList
                        //I'm not sure how you're going to do comparison, so you'll need to fill out this conditional

                        /*
                        // Compare anywhere
                        if(data.name.toLowerCase().contains(toCompare) || data.part.toLowerCase().contains(toCompare))
                        {
                            filterResultsData.add(data);
                        }*/


                        if(data.name.toLowerCase().startsWith(toCompare) || data.part.toLowerCase().startsWith(toCompare))
                        {
                            filterResultsData.add(data);
                        }
                    }

                    results.values = filterResultsData;
                    results.count = filterResultsData.size();
                }

                return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults)
            {
                filteredItems = (ArrayList<Item>)filterResults.values;
                System.out.println(filteredItems.size());

                notifyDataSetChanged();
            }
        };
    }

    @Override
    public int getCount()
    {
        return filteredItems.size();
    }
}
