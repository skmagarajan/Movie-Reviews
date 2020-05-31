package com.example.proj2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView l;

    private String[] movie_name;
    private String[] year_released;

    private String[] youtube_links;
    private String[] wiki_links;
    private String[] imdb_links;

   Integer[] thumbnail = {R.drawable.joker,R.drawable.parasite,R.drawable.irishman,R.drawable.gifted,R.drawable.blackpanther,R.drawable.revenant};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movie_name = getResources().getStringArray(R.array.movie_name);
        year_released = getResources().getStringArray(R.array.year_released);

        youtube_links = getResources().getStringArray(R.array.youtube_links);
        wiki_links = getResources().getStringArray(R.array.wiki_links);
        imdb_links = getResources().getStringArray(R.array.imdb_links);


        //Creating adapter object for movieListAdapter
        MovieListAdapter adapter = new MovieListAdapter(this, movie_name,year_released,thumbnail);
        l = (ListView)findViewById(R.id.list);

        //Set adapter in listview
        l.setAdapter(adapter);

        //OnItemclickListener
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent in = new Intent(MainActivity.this, SecondActivity.class);
                Bundle b = new Bundle();
                b.putString("Position",Integer.toString(position));
                in.putExtras(b);
                startActivity(in);
            }
        });

        onTrimMemory(TRIM_MEMORY_BACKGROUND);  // To free RAM space

        l.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(), "Long Click ", Toast.LENGTH_SHORT).show();
                registerForContextMenu(l);
                return false;
            }
        });
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0,v.getId(),0,"Info about movie");
        menu.add(0,v.getId(),0,"Watch Trailer");
        menu.add(0,v.getId(),0,"Info about director");
        menu.add(0,v.getId(),0,"IMDb review");
    }

    public boolean onContextItemSelected(MenuItem item){
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        if(item.getTitle().equals("Info about movie")){
            Intent third = new Intent(MainActivity.this,ThirdActivity.class);
            Bundle b = new Bundle();
            b.putString("position",(Integer.toString(info.position)));
            third.putExtras(b);
            startActivity(third);
        }
        if(item.getTitle().equals("Watch Trailer")){
            Intent out = new Intent(Intent.ACTION_VIEW, Uri.parse(youtube_links[info.position]));
            startActivity(out);
        }
        if(item.getTitle() == "Info about director"){
            Intent out = new Intent(Intent.ACTION_VIEW, Uri.parse(wiki_links[info.position]));
            startActivity(out);

        }
        if(item.getTitle() ==  "IMDb review"){
            Intent out = new Intent(Intent.ACTION_VIEW, Uri.parse(imdb_links[info.position]));
            startActivity(out);
        }
        return true;
    }

}
