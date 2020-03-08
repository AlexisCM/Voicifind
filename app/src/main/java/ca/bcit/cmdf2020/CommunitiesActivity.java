package ca.bcit.cmdf2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CommunitiesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communities);

        BottomNavigationView navView = findViewById(R.id.nav_view_communities);
        navView.getMenu().getItem(0).setIcon(R.drawable.ic_home_black_24dp);
        navView.getMenu().getItem(1).setIcon(R.drawable.ic_dashboard_black_24dp);
        navView.getMenu().getItem(2).setIcon(R.drawable.ic_edit_black_24dp);
        navView.getMenu().getItem(3).setIcon(R.drawable.ic_message_black_24dp);
        int size = navView.getMenu().size();
        for (int i = 0; i < size; i++) {
            navView.getMenu().getItem(i).setChecked(false);
        }
        navView.getMenu().getItem(1).setChecked(true);

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_home:
                        startActivity(new Intent(CommunitiesActivity.this, HomepageActivity.class));
                        menuItem.setChecked(true);
                        break;
                    case R.id.navigation_communities:
                        menuItem.setChecked(true);
                        break;
                    case R.id.navigation_post:
                        startActivity(new Intent(CommunitiesActivity.this, PostsActivity.class));
                        menuItem.setChecked(true);
                        break;
                    case R.id.navigation_chat:
                        startActivity(new Intent(CommunitiesActivity.this, ChatActivity.class));
                        menuItem.setChecked(true);
                        break;
                }
                return false;
            }
        });
    }
}
