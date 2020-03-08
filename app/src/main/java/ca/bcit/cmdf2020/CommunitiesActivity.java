package ca.bcit.cmdf2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CommunitiesActivity extends AppCompatActivity {
    private JSONObject jsonDBObject;
    private String url = "https://voicifind.firebaseio.com/communities/.json";
    int listLength;

    DatabaseReference communitydbRef;
    ListView communityListView;
    List<String> communityList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communities);

        communitydbRef = FirebaseDatabase.getInstance().getReference("communities");
        communityListView = findViewById(R.id.list_communities);
        communityList = new ArrayList<>();

        BottomNavigationView navView = findViewById(R.id.nav_view_communities);
        navView.getMenu().getItem(0).setIcon(R.drawable.ic_home_black_24dp);
        navView.getMenu().getItem(1).setIcon(R.drawable.ic_edit_black_24dp);
        navView.getMenu().getItem(2).setIcon(R.drawable.ic_business_black_24dp);
        int size = navView.getMenu().size();
        for (int i = 0; i < size; i++) {
            navView.getMenu().getItem(i).setChecked(false);
        }
        navView.getMenu().getItem(2).setChecked(true);

        sendAndRequestResponse();

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_home:
                        startActivity(new Intent(CommunitiesActivity.this, HomepageActivity.class));
                        menuItem.setChecked(true);
                        break;
                    case R.id.navigation_post:
                        startActivity(new Intent(CommunitiesActivity.this, PostsActivity.class));
                        menuItem.setChecked(true);
                        break;
                    case R.id.navigation_communities:
                        menuItem.setChecked(true);
                        break;
                }
                return false;
            }
        });

    }


    private void sendAndRequestResponse() {
        //RequestQueue initialized
        RequestQueue mRequestQueue = Volley.newRequestQueue(this);

        //String Request initialized
        JsonObjectRequest mJsonRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                jsonDBObject = response;
                Log.e("Test", response.toString());
                Log.e("Test2", jsonDBObject.toString());
                populatePage();
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("TAG", "Error :" + error.toString());
            }
        });
        mRequestQueue.add(mJsonRequest);
    }

    public void populatePage() {
        try {
            JSONArray hashJsonArray = jsonDBObject.names();
            assert hashJsonArray != null;
            listLength = hashJsonArray.length();
            List<String> ListOfCommunity = new ArrayList<>(listLength);
            for (int i = 0; i < hashJsonArray.length(); i++) {
                String key = hashJsonArray.get(i).toString();
                JSONObject communityObj = (JSONObject) jsonDBObject.get(key);
                String communityName = communityObj.getString("communityName");
                ListOfCommunity.add(communityName);
            }
            ListView commListView = findViewById(R.id.list_communities);
            commListView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ListOfCommunity));
        } catch (JSONException e) {
            Log.e("userListConversion: ", e.toString());
        }
    }
}
