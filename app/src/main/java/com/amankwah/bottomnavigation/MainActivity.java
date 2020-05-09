package com.amankwah.bottomnavigation;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.amankwah.bottomnavigation.ui.home.HomeFragment;
import com.amankwah.bottomnavigation.ui.dashboard.DashboardFragment;
import com.amankwah.bottomnavigation.ui.notifications.NotificationsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;



public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(this);


        loadFragment(new HomeFragment());


    }

    private boolean loadFragment(Fragment fragment){
        if(fragment !=null){

         getSupportFragmentManager()
                 .beginTransaction()
                 .replace(R.id.nav_host_fragment, fragment)
                 .commit();



            return true;
        }
        return false;
    }

    @Override
    public  boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment = null;

        switch(item.getItemId()) {

            case R.id.navigation_home:
                fragment = new HomeFragment();
                break;

            case R.id.navigation_create:
                fragment = new DashboardFragment();
                break;

            case R.id.navigation_account:
                fragment = new NotificationsFragment();
                break;

        }

        return loadFragment(fragment);
    }
}

