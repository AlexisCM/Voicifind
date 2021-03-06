package ca.bcit.cmdf2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timer = new Timer();
        timer.schedule(new OnLoadDelay(), 1500);

    }

    class OnLoadDelay extends TimerTask {
        public void run() {
            timer.cancel();
            startActivity(new Intent(MainActivity.this, HomepageActivity.class));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        timer = new Timer();
        timer.schedule(new OnLoadDelay(), 1500);
    }
}
