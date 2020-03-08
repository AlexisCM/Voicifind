package ca.bcit.cmdf2020.ui.communitites;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CommunitiesViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public CommunitiesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Community fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
