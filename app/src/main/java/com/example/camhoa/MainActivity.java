package com.example.camhoa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomnavigationview;

    FragmentFavorite favorite ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment,new FragmentHome()).commit();
        EventClickBottomNavigationView();
    }

    private void EventClickBottomNavigationView() {
        bottomnavigationview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_bottom_home:
                        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment,new FragmentHome()).commit();
                        break;
                    case R.id.menu_bottom_user:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new FragmentProfile()).commit();
                        break;
                    case R.id.menu_bottom_favorite:
                        if (favorite ==null) favorite = new FragmentFavorite();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment,favorite).commit();
                        break;
                }
                return true;
            }
        });
    }

    private void mapping() {
        bottomnavigationview=findViewById(R.id.bottomnavigationview);
    }
}