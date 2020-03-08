package ca.bcit.cmdf2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CommunitiesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communities);

        BottomNavigationView navView = findViewById(R.id.nav_view);

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_home:
                        startActivity(new Intent(CommunitiesActivity.this, HomepageActivity.class));
                        break;
                    case R.id.navigation_communities:
                        break;
                    case R.id.navigation_post:
                        startActivity(new Intent(CommunitiesActivity.this, PostsActivity.class));
                        break;
                }
                return false;
            }
        });
    }
}
