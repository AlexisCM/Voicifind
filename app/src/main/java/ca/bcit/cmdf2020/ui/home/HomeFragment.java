package ca.bcit.cmdf2020.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import ca.bcit.cmdf2020.Message;
import ca.bcit.cmdf2020.R;

public class HomeFragment extends Fragment {
    private DatabaseReference homeReference;
    private ListView listViewPosts;
    private List<Message> postsList;
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        homeReference = FirebaseDatabase.getInstance().getReference("messages");
        listViewPosts = root.findViewById(R.id.postsListView);
        postsList = new ArrayList<>();
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        homeReference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                postsList.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Message post = postSnapshot.getValue(Message.class);
                    postsList.add(post);
                }
                
                PostListAdapter adapter = new PostListAdapter(HomeFragment.this, postsList);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}