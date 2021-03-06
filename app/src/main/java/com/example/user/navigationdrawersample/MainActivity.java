package com.example.user.navigationdrawersample;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.io.Console;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        toggleDrawer();
        initializeDefaultFragment(savedInstanceState,0);





    }



    /**
     * Initialize all widgets
     */
    private void initializeViews() {
        toolbar = findViewById(R.id.toolbar_id);
        toolbar.setTitle(R.string.toolbar_title);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout_id);
        navigationView = findViewById(R.id.navigationview_id);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getScaleX();
        navigationView.getScaleY();

    }

    /**
     * Checks if the savedInstanceState is null - onCreate() is ran
     * If so, display fragment of navigation drawer menu at position itemIndex and
     * set checked status as true
     * @param savedInstanceState
     * @param itemIndex
     */
    private void initializeDefaultFragment(Bundle savedInstanceState, int itemIndex){
        if (savedInstanceState == null){
            MenuItem menuItem = navigationView.getMenu().getItem(itemIndex).setChecked(true);
            onNavigationItemSelected(menuItem);
        }
    }

    /**
     * Creates an instance of the ActionBarDrawerToggle class:
     * 1) Handles opening and closing the navigation drawer
     * 2) Creates a hamburger icon in the toolbar
     * 3) Attaches listener to open/close drawer on icon clicked and rotates the icon
     */
    private void toggleDrawer() {
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {
        //Checks if the navigation drawer is open -- If so, close it
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        // If drawer is already close -- Do not override original functionality
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){

            case R.id.nav_welcome_id:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id, new HomeFragment())
                        .commit();
                closeDrawer();
                break;
            case R.id.nav_view_id:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id, new ViewFragment3())
                        .commit();
                closeDrawer();
                break;
            case R.id.nav_control_id:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id, new BlankFragment3())
                        .commit();
                closeDrawer();
                break;
            case R.id.nav_creat_id:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id, new CreatFragment4())
                        .commit();
                closeDrawer();
                break;

            case R.id.nav_message_id:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id, new MessageFragment())
                        .commit();
                closeDrawer();
                break;
            case R.id.nav_chat_id:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id, new ChatFragment())
                        .commit();
                closeDrawer();
                break;
            case R.id.nav_profile_id:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id, new ProfileFragment())
                        .commit();
                closeDrawer();
                break;
            case R.id.nav_notebooks_id:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id,new NotebooksFragment())
                        .commit();
                closeDrawer();
                break;
            case R.id.nav_send_id:
                String url = "https://www.google.com/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                break;
            case R.id.nav_share_id:
                Toast.makeText(this, "Copied Link", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_photos_id:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id,new BlankFragment())
                        .commit();
                closeDrawer();
                break;

            case R.id.nav_settings_id:
                Intent myint = new Intent(this, land.class);
                startActivity(myint);
                break;
            case R.id.nav_darkmode_id:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id,new BlankFragment2())
                        .commit();
                closeDrawer();
                break;
        }
        return true;
    }






    /**
     * Checks if the navigation drawer is open - if so, close it
     */
    private void closeDrawer(){
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    /**
     * Iterates through all the items in the navigation menu and deselects them:
     * removes the selection color
     */
    private void deSelectCheckedState(){
        int noOfItems = navigationView.getMenu().size();
        for (int i=0; i<noOfItems;i++){
            navigationView.getMenu().getItem(i).setChecked(false);
        }
    }

    public void order(View view) {
        Toast.makeText(this, "Order Created", Toast.LENGTH_LONG).show();
    }
}
