package com.example.proj2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import static android.provider.ContactsContract.CommonDataKinds.StructuredName.PREFIX;

public class SecondActivity extends Activity {

    private String[] imdb_links;

    public void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.second_activity);
        Intent in = getIntent();
        Bundle b = in.getExtras();
        final int position = Integer.parseInt(b.get("Position").toString());
        ImageView bt = (ImageView)findViewById(R.id.img);

        Integer[] movie_images = {R.drawable.joker_high,R.drawable.parasite_hd,R.drawable.irishman_hd,R.drawable.gifted_hd,R.drawable.blackpanther_hd,R.drawable.revenant_hd};

        imdb_links = getResources().getStringArray(R.array.imdb_links);

        bt.setBackgroundResource(movie_images[position]);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent out = new Intent(Intent.ACTION_VIEW, Uri.parse(imdb_links[position]));
                startActivity(out);
            }
        });
    }
}

