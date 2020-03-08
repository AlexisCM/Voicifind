package ca.bcit.cmdf2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        BottomNavigationView navView = findViewById(R.id.nav_view);

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_home:
                        startActivity(new Intent(ChatActivity.this, HomepageActivity.class));
                        break;
                    case R.id.navigation_communities:
                        startActivity(new Intent(ChatActivity.this, CommunitiesActivity.class));
                        break;
                    case R.id.navigation_post:
                        startActivity(new Intent(ChatActivity.this, PostsActivity.class));
                        break;
                    case R.id.navigation_chat:
                        break;
                }
                return false;
            }
        });
    }
}
