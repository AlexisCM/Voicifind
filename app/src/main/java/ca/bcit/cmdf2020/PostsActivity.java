package ca.bcit.cmdf2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PostsActivity extends AppCompatActivity {
    DatabaseReference messagedbRef;
    EditText makeNewPost;
    Spinner communitySelect;
    Button postButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        messagedbRef = FirebaseDatabase.getInstance().getReference("messages");
        makeNewPost = (EditText) findViewById(R.id.make_new_post);
        communitySelect = (Spinner) findViewById(R.id.community_spinner);
        postButton = (Button) findViewById(R.id.postButton);

        BottomNavigationView navView = findViewById(R.id.nav_view_posts);
        navView.getMenu().getItem(0).setIcon(R.drawable.ic_home_black_24dp);
        navView.getMenu().getItem(1).setIcon(R.drawable.ic_dashboard_black_24dp);
        navView.getMenu().getItem(2).setIcon(R.drawable.ic_edit_black_24dp);
        navView.getMenu().getItem(3).setIcon(R.drawable.ic_message_black_24dp);
        int size = navView.getMenu().size();
        for (int i = 0; i < size; i++) {
            navView.getMenu().getItem(i).setChecked(false);
        }
        navView.getMenu().getItem(2).setChecked(true);

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_home:
                        startActivity(new Intent(PostsActivity.this, HomepageActivity.class));
                        menuItem.setChecked(true);
                        break;
                    case R.id.navigation_communities:
                        startActivity(new Intent(PostsActivity.this, CommunitiesActivity.class));
                        menuItem.setChecked(true);
                        break;
                    case R.id.navigation_post:
                        menuItem.setChecked(true);
                        break;
                    case R.id.navigation_chat:
                        startActivity(new Intent(PostsActivity.this, ChatActivity.class));
                        menuItem.setChecked(true);
                        break;
                }
                return false;
            }
        });

        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!makeNewPost.getText().toString().equals("")) {
                    add_post();
                    startActivity(new Intent(PostsActivity.this, HomepageActivity.class));
                }
            }
        });
    }

    private void add_post() {
        String id = messagedbRef.push().getKey();
        Message msg = new Message(id, communitySelect.getSelectedItem().toString(), makeNewPost.getText().toString());

        Task setValueTask = messagedbRef.child(id).setValue(msg);

        setValueTask.addOnSuccessListener(new OnSuccessListener() {
            @Override
            public void onSuccess(Object o) {
                Toast.makeText(PostsActivity.this, "Your post has been made.",
                        Toast.LENGTH_LONG).show();
            }
        });

        setValueTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(PostsActivity.this,
                        "Sorry! We couldn't make your post!" + e.toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

}
