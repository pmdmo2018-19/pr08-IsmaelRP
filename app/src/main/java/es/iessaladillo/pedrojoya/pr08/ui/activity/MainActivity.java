package es.iessaladillo.pedrojoya.pr08.ui.activity;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.preference.PreferenceManager;
import es.iessaladillo.pedrojoya.pr08.R;
import es.iessaladillo.pedrojoya.pr08.ui.fragment.MainFragment;
import es.iessaladillo.pedrojoya.pr08.ui.fragment.SecondFragment;
import es.iessaladillo.pedrojoya.pr08.ui.fragment.SettingsFragment;
import es.iessaladillo.pedrojoya.pr08.utils.FragmentUtils;

public class MainActivity extends AppCompatActivity {

    private MainViewModel vm;
    private SharedPreferences preferences;
    private NavController navController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navController = Navigation.findNavController(this, R.id.navHostFragment);
        vm = ViewModelProviders.of(this).get(MainViewModel.class);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        if (preferences != null){
            checkPreferences();
        }else{
            updateVM(getString(R.string.main_latin_ipsum));
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

}
