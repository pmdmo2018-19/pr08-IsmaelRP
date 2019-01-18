package es.iessaladillo.pedrojoya.pr08.ui.activity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private final MutableLiveData<String> loremType = new MutableLiveData<>();

    public LiveData<String> getLoremType() {
        return loremType;
    }

    public void setLoremType(String type) {
        loremType.setValue(type);
    }
}
