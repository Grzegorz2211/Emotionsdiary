package com.example.emotnionsdiary

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.emotnionsdiary.database.Diary
import com.example.emotnionsdiary.database.DiaryDatabaseHelper
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        if (savedInstanceState == null) {


        }
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.nav_logout -> Toast.makeText(this, "Logout!", Toast.LENGTH_SHORT).show()
            R.id.nav_login -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, LoginFragment()).commit()
            R.id.nav_diary -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, DiaryFragment()).commit()
            R.id.nav_SettingsFragments -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container,SettingsFragment ()).commit()
            R.id.nav_view_diary -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container,DiaryViewAll ()).commit()
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}
