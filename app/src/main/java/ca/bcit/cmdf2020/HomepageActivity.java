package ca.bcit.cmdf2020;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class HomepageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_home:
                        break;
                    case R.id.navigation_communities:
                        startActivity(new Intent(HomepageActivity.this, CommunitiesActivity.class));
                        break;
                    case R.id.navigation_post:
                        startActivity(new Intent(HomepageActivity.this, PostsActivity.class));
                        break;
                    case R.id.navigation_chat:
                        startActivity(new Intent(HomepageActivity.this, ChatActivity.class));
                        break;
                }
                return false;
            }
        });
    }

}
