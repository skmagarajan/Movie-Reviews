package com.example.proj2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class ThirdActivity extends Activity {

    private String[] movie_name;

    private String[] year_released;

    String[] duration = {"2h 2min","2h 12min","3h 29min","1h 41min","2h 14min","2h 36min "};

    String[] director = {"Todd Phillips","Bong Joon Ho","Martin Scorsese","Marc Webb","Ryan Coogler","Alejandro G. Iñárritu"};

    String[] stars = {"Joaquin Phoenix, Robert De Niro, Zazie Beetz","Kang-ho Song, Sun-kyun Lee, Yeo-jeong Jo","Robert De Niro, Al Pacino, Joe Pesci","Chris Evans, Mckenna Grace, Lindsay Duncan",
                        "Chadwick Boseman, Michael B. Jordan, Lupita Nyong'o","Leonardo DiCaprio, Tom Hardy, Will Poulter"};

    float[] imdb_rating = {4.3f,4.3f,4.0f,3.8f,3.6f,4.0f};

    float[] rotten_rating = {3.5f,3.6f,4.8f,3.9f,4.7f,4.2f};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Intent in = getIntent();
        Bundle b = in.getExtras();
        String position = (String)b.get("position");

        movie_name = getResources().getStringArray(R.array.movie_name);
        year_released = getResources().getStringArray(R.array.year_released);

        TextView mv = (TextView)findViewById(R.id.movie);
        TextView yr = (TextView)findViewById(R.id.year);
        TextView dur = (TextView)findViewById(R.id.duration);
        TextView dir = (TextView)findViewById(R.id.director);
        TextView star = (TextView)findViewById(R.id.stars);
        RatingBar imdb = (RatingBar) findViewById(R.id.imdb_RatingBar);
        RatingBar rot = (RatingBar)findViewById(R.id.rotten_RatingBar);

        Integer index = Integer.parseInt(position);

        mv.setText(movie_name[index]);
        yr.setText(year_released[index]);
        dur.setText(duration[index]);
        dir.setText(director[index]);
        star.setText(stars[index]);
        imdb.setRating(imdb_rating[index]);
        rot.setRating(rotten_rating[index]);

    }
}
