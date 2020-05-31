package com.example.proj2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.menu.ListMenuItemView;

import com.example.proj2.R;

public class MovieListAdapter extends BaseAdapter {

    private final String[] movie_name;
    private final String[] year_released;
    private final Integer[] thumbnail;
    private final Context context;

    private static class ViewHolder {

        TextView m_name;
        TextView y_released;
        ImageView poster;

    }

    MovieListAdapter(Context c, String[] movie_name, String[] year_released, Integer[] thumbnail) {
        this.context = c;
        this.movie_name = movie_name;
        this.year_released = year_released;
        this.thumbnail = thumbnail;
    }

    public int getCount() {
        return thumbnail.length;
    }

    @Override
    public Object getItem(int position) {
        return thumbnail[position];
    }

    @Override
    public long getItemId(int position) {
        return thumbnail[position];
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder v;

        final View result;

        if(convertView == null) {           //For Recycle purpose checking

            v = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.movie_list, parent, false);
            v.m_name = (TextView) convertView.findViewById(R.id.movie_name);
            v.y_released = (TextView) convertView.findViewById(R.id.year_released);
            v.poster = (ImageView) convertView.findViewById(R.id.movie_poster);

            result = convertView;

            convertView.setTag(v);
        }
        else {
            v = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        v.m_name.setText(movie_name[position]);
        v.y_released.setText(year_released[position]);
        v.poster.setImageResource(thumbnail[position]);

        return convertView;
    }

}

