package bussapp_mobile.juniorsantos.example.com.bussapp_mobile.activity;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import bussapp_mobile.juniorsantos.example.com.bussapp_mobile.R;

public class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    protected void setUpToolbar() {
        Toolbar t = findViewById(R.id.toolbar);

        if (t != null) {
            setSupportActionBar(t);
        }
    }

    protected void setUpMenu() {
        ActionBar ab = getSupportActionBar();

        if (ab != null) {
            ab.setHomeAsUpIndicator(R.drawable.ic_menu);
            ab.setDisplayHomeAsUpEnabled(true);

            onMenuSetUp();
        }
    }

    private void onMenuSetUp() {
        DrawerLayout drawerLayout = getDrawer();

        if (drawerLayout != null) {
            NavigationView navigationView = findViewById(R.id.navigationView);

            navigationView.setNavigationItemSelectedListener(BaseActivity.this);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                DrawerLayout drawerLayout = getDrawer();
                if (drawerLayout != null)
                    drawerLayout.openDrawer(GravityCompat.START);
                break;

            case R.id.configApp:
                Intent i = new Intent(BaseActivity.this, ConfigureActivity.class);
                startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawerLayout = getDrawer();
        if (drawerLayout != null) {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawers();
                return;
            }

        }
        super.onBackPressed();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_config, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        menuItem.setCheckable(true);
        onItemSelected(menuItem);

        DrawerLayout drawerLayout = getDrawer();
        if (drawerLayout != null) {
            drawerLayout.closeDrawers();
        }

        return true;
    }

    private void onItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.telaFuncionarios:
                startActivity(new Intent(this, FuncionarioActivity.class));
                break;
        }
    }

    private DrawerLayout getDrawer() {
        return (DrawerLayout) findViewById(R.id.drawerLayout);
    }
}
