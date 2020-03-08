package ca.bcit.cmdf2020;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.List;

public class PostListAdapter extends ArrayAdapter<Message> {
    private Activity context;
    private List<Message> postList;

    public PostListAdapter(Activity context, List<Message> postList) {
        super(context, R.layout.layout_post_list, postList);
        this.context = context;
        this.postList = postList;
    }

    public PostListAdapter(Context context, int res,
                              List<Message> obj, Activity context1, List<Message> postList) {
        super(context, res, obj);
        this.context = context1;
        this.postList = postList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.layout_post_list, null, true);

        TextView tvMessage = listViewItem.findViewById(R.id.textView_msgStr);
        TextView tvCommunity = listViewItem.findViewById(R.id.textView_community);
        TextView tvTime = listViewItem.findViewById(R.id.textView_time);

        Message post = postList.get(position);

        tvMessage.setText(post.getMessageString());
        tvCommunity.setText(post.getCommunity());
        tvTime.setText(post.getTime());

        return listViewItem;
    }

}
