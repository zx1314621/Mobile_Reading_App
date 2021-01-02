package scu.edu.fastreading.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.xyz.xswitch.XyzSwitch;

import scu.edu.fastreading.R;

public class MainActivity extends AppCompatActivity {
    Toolbar myToolbar;
    ImageButton search;
    ImageButton arrow;
    ImageButton search1;
    ImageButton girl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        myToolbar = (Toolbar)findViewById(R.id.myToolbar);
        search = (ImageButton)findViewById(R.id.search);
        search1 = (ImageButton)findViewById(R.id.search1);
        arrow = (ImageButton)findViewById(R.id.arrow);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_book, R.id.navigation_store, R.id.navigation_profile)
                .build();
        //getSupportActionBar().hide();

        setSupportActionBar(myToolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
       // NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

    }

}