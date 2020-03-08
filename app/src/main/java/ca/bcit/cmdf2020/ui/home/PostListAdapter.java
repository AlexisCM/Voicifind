package ca.bcit.cmdf2020.ui.home;

import android.app.Activity;
import android.widget.ArrayAdapter;

import java.util.List;

import ca.bcit.cmdf2020.Message;
import ca.bcit.cmdf2020.R;

public class PostListAdapter extends ArrayAdapter<Message> {
    public PostListAdapter(Activity context, List<Message> postList) {
        super(context, R.layout.layout_post_list);
    }
}
