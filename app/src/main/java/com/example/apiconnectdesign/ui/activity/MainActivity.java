package com.example.apiconnectdesign.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.apiconnectdesign.ui.fragments.AccountFragment;
import com.example.apiconnectdesign.ui.fragments.HomeFragment;
import com.example.apiconnectdesign.ui.fragments.MoreFragment;
import com.example.apiconnectdesign.ui.fragments.ProvincesFragment;
import com.example.apiconnectdesign.R;
import com.example.apiconnectdesign.ui.fragments.SearchFragment;
import com.example.apiconnectdesign.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //create obj binding for call layout-view
        com.example.apiconnectdesign.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());

        //call layout-view by binding obj
        setContentView(binding.getRoot());

        //Init fragment-layout to MainActivity
        showFragment(new HomeFragment());

        //Setup listener for mapping other fragment layout-view to lytFragment of MainActivity
        binding.idBottomNavigationBar.setOnItemSelectedListener(item -> {
            if(item.getItemId()== R.id.id_mnHome){
                showFragment(new HomeFragment());
            }else if(item.getItemId()==R.id.id_mnProvinces){
                showFragment(new ProvincesFragment());
            }else if(item.getItemId()==R.id.id_mnSearch){
                showFragment(new SearchFragment());
            }else if(item.getItemId()==R.id.id_mnAccount){
                showFragment(new AccountFragment());
            }else if(item.getItemId()==R.id.id_mnMore){
                showFragment(new MoreFragment());
            }
            return  true;
        });
    }

    //function map fragment-layout to menu-item in bottom-navigation-bar
    public void showFragment(Fragment fragment){

        //Create fragment manager
        FragmentManager fragmentManager = getSupportFragmentManager();

        //Create fragment transaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //Replace fragment-layout in lytFragment of main-activity
        fragmentTransaction.replace(R.id.lytFragment,fragment);

        //Commit transaction
        fragmentTransaction.commit();

    }
}