package ca.bcit.cmdf2020.ui.communitites;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import ca.bcit.cmdf2020.R;

public class CommunitiesFragment extends Fragment {
    private CommunitiesViewModel communitiesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        communitiesViewModel =
                ViewModelProviders.of(this).get(CommunitiesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_communities, container, false);
        final TextView textView = root.findViewById(R.id.text_communities);
        communitiesViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
