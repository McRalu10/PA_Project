package com.example.studenthotel

import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.customview.widget.Openable
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController
    lateinit var drawerLayout: DrawerLayout
    lateinit var toolbar: Toolbar
    lateinit var bottomNavigationView: BottomNavigationView
    lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = findNavController(R.id.main_nav_host) //Initialising navController
        drawerLayout = findViewById(R.id.main_drawer_layout)
        toolbar = findViewById(R.id.main_toolbar)
        bottomNavigationView = findViewById(R.id.main_bottom_navigation_view)
        navigationView = findViewById(R.id.main_navigation_view)
        appBarConfiguration = AppBarConfiguration.Builder(R.id.nav_home, R.id.nav_rooms, R.id.nav_prices,
                R.id.nav_about, R.id.nav_contact, R.id.action_explore, R.id.action_inbox, R.id.action_profile)
                .setOpenableLayout(drawerLayout)
                .build()

        setSupportActionBar(toolbar) //Set toolbar

        setupActionBarWithNavController(navController, appBarConfiguration) //Setup toolbar with back button and drawer icon according to appBarConfiguration

        visibilityNavElements(navController) //If you want to hide drawer or bottom navigation configure that in this function

//        BottomNavigationView.OnNavigationItemSelectedListener { item ->
//            when(item.itemId) {
//                R.id.bottom_explore -> {
//                    // Respond to navigation item 1 click
//                    true
//                }
//                R.id.item2 -> {
//                    // Respond to navigation item 2 click
//                    true
//                }
//                else -> false
//            }
//        }
    }

    private fun visibilityNavElements(navController: NavController) {

        //Listen for the change in fragment (navigation) and hide or show drawer or bottom navigation accordingly if required
        //Modify this according to your need
        //If you want you can implement logic to deselect(styling) the bottom navigation menu item when drawer item selected using listener

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                 R.id.nav_about -> hideBottomNavigation()
                R.id.nav_contact -> hideBottomNavigation()
                R.id.nav_rooms -> hideBottomNavigation()
                R.id.nav_prices -> hideBottomNavigation()
                else -> showBothNavigation()
            }
        }

    }


    private fun hideBothNavigation() { //Hide both drawer and bottom navigation bar
        bottomNavigationView.visibility = View.GONE
        navigationView.visibility = View.GONE
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED) //To lock navigation drawer so that it don't respond to swipe gesture
    }

    private fun hideBottomNavigation() { //Hide bottom navigation
        bottomNavigationView.visibility = View.GONE
        navigationView.visibility = View.VISIBLE
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED) //To unlock navigation drawer

        navigationView.setupWithNavController(navController) //Setup Drawer navigation with navController
    }

    private fun showBothNavigation() {
        bottomNavigationView.visibility = View.VISIBLE
        navigationView.visibility = View.VISIBLE
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
        setupNavControl() //To configure navController with drawer and bottom navigation
    }

    private fun setupNavControl() {
        navigationView.setupWithNavController(navController) //Setup Drawer navigation with navController
        bottomNavigationView.setupWithNavController(navController) //Setup Bottom navigation with navController
    }

    fun exitApp() { //To exit the application call this function from fragment
        this.finishAffinity()
    }

    override fun onSupportNavigateUp(): Boolean { //Setup appBarConfiguration for back arrow
        return NavigationUI.navigateUp(navController, appBarConfiguration)
    }

    override fun onBackPressed() {
        when { //If drawer layout is open close that on back pressed
            drawerLayout.isDrawerOpen(GravityCompat.START) -> {
                drawerLayout.closeDrawer(GravityCompat.START)
            }
            else -> {
                super.onBackPressed() //If drawer is already in closed condition then go back
            }
        }
    }
}