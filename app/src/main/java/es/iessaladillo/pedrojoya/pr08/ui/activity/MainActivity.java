package es.iessaladillo.pedrojoya.pr08.ui.activity;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.preference.PreferenceManager;
import es.iessaladillo.pedrojoya.pr08.R;
import es.iessaladillo.pedrojoya.pr08.ui.fragment.MainFragment;
import es.iessaladillo.pedrojoya.pr08.ui.fragment.SecondFragment;
import es.iessaladillo.pedrojoya.pr08.ui.fragment.SettingsFragment;
import es.iessaladillo.pedrojoya.pr08.utils.FragmentUtils;

public class MainActivity extends AppCompatActivity implements MainFragment.Navigate {

    private MainViewModel vm;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vm = ViewModelProviders.of(this).get(MainViewModel.class);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        if (preferences != null){
            checkPreferences();
        }else{
            updateVM(getString(R.string.main_latin_ipsum));
        }

        if (getSupportFragmentManager().findFragmentByTag(MainFragment.class.getSimpleName()) == null) {
            FragmentUtils.replaceFragment(getSupportFragmentManager(), R.id.flContent, new MainFragment(), MainFragment.class.getSimpleName());
        }

    }

    private void updateVM(String update) {
        vm.setLoremType(update);
    }

    private void checkPreferences() {
        updateVM(preferences.getString(getString(R.string.loremType),getString(R.string.loremDefault)));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void navigateTo(Navigations num) {
        if (num == Navigations.SECOND) {
            FragmentUtils.replaceFragmentAddToBackstack(getSupportFragmentManager(), R.id.flContent, new SecondFragment(), SecondFragment.class.getSimpleName(), SecondFragment.class.getSimpleName(), FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        } else {
            FragmentUtils.replaceFragmentAddToBackstack(getSupportFragmentManager(), R.id.flContent, new SettingsFragment(), SettingsFragment.class.getSimpleName(), SettingsFragment.class.getSimpleName(), FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        }
    }
}
