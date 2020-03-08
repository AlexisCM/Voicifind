package ca.bcit.cmdf2020;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class HomepageActivity extends AppCompatActivity {
    DatabaseReference dbRef;
    ListView postsListView;
    List<Message> postsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        dbRef = FirebaseDatabase.getInstance().getReference("messages");

        postsListView = findViewById(R.id.posts_listView);
        postsList = new ArrayList<>();

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

//        add_post();
    }

//    private void add_post() {
//        String id = dbRef.push().getKey();
//        Message msg = new Message(id, "BCIT", "This is hellllllll");
//
//        Task setValueTask = dbRef.child(id).setValue(msg);
//
//        setValueTask.addOnSuccessListener(new OnSuccessListener() {
//            @Override
//            public void onSuccess(Object o) {
//                Toast.makeText(HomepageActivity.this, "good",
//                        Toast.LENGTH_LONG).show();
//            }
//        });
//
//        setValueTask.addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Toast.makeText(HomepageActivity.this,
//                        "OOPS. You done goofed: " + e.toString(),
//                        Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

    @Override
    protected void onStart() {
        super.onStart();

        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                postsList.clear();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Message post = postSnapshot.getValue(Message.class);
                    postsList.add(post);
                }

                postsListView.setAdapter(new PostListAdapter(HomepageActivity.this, postsList));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
