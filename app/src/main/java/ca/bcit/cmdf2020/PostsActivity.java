package ca.bcit.cmdf2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PostsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        BottomNavigationView navView = findViewById(R.id.nav_view);

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_home:
                        startActivity(new Intent(PostsActivity.this, HomepageActivity.class));
                        break;
                    case R.id.navigation_communities:
                        startActivity(new Intent(PostsActivity.this, CommunitiesActivity.class));
                        break;
                    case R.id.navigation_post:
                        break;
                    case R.id.navigation_chat:
                        startActivity(new Intent(PostsActivity.this, ChatActivity.class));
                        break;
                }
                return false;
            }
        });
    }
}
