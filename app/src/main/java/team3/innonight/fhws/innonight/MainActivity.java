package team3.innonight.fhws.innonight;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import team3.innonight.fhws.innonight.model.Category;
import team3.innonight.fhws.innonight.model.User;
import team3.innonight.fhws.innonight.service.CategoryService;
import team3.innonight.fhws.innonight.service.NotificationService;
import team3.innonight.fhws.innonight.service.UserService;
import team3.innonight.fhws.innonight.viewAdapters.EntryAdapter;
import team3.innonight.fhws.innonight.viewAdapters.EntryHolder;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        this.loadUser();

        NotificationService.setContext((NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE), getApplicationContext());

    }

    private void loadUser() {
        User user = UserService.getUser();

        View headerView = navigationView.getHeaderView(0);

        ImageView navImage = (ImageView) headerView.findViewById(R.id.navImage);
        TextView navUsername = (TextView) headerView.findViewById(R.id.navUsername);
        TextView navEmail = headerView.findViewById(R.id.navEmail);

        navImage.setImageResource(user.getIcon());
        navUsername.setText(user.getFirstname() + " " + user.getSurname());
        navEmail.setText(user.getEmail());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if(id == R.id.nav_start) {
            FragmentManager fragmentManager = getFragmentManager();

            fragmentManager.beginTransaction()
                    .replace(R.id.main_fragment, new CategoryFragment())
                    .addToBackStack(null)
                    .commit();
        } else if (id == R.id.nav_camera) {
            ImageFragment fragment = new ImageFragment();

            android.app.FragmentManager fragmentManager = getFragmentManager();

            fragmentManager.beginTransaction()
                    .replace(R.id.main_fragment, fragment)
                    .addToBackStack(null)
                    .commit();

        } else if (id == R.id.nav_events) {
            NotificationFragment fragment = new NotificationFragment();

            android.app.FragmentManager fragmentManager = getFragmentManager();

            fragmentManager.beginTransaction()
                    .replace(R.id.main_fragment, fragment)
                    .addToBackStack(null)
                    .commit();

        } else if(id == R.id.nav_account) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("User", UserService.getUser());

            UserFragment fragment = new UserFragment();
            fragment.setArguments(bundle);

            android.app.FragmentManager fragmentManager = getFragmentManager();

            fragmentManager.beginTransaction()
                    .replace(R.id.main_fragment, fragment)
                    .addToBackStack(null)
                    .commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
