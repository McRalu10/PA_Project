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
import com.example.studenthotel.databinding.ActivityMainBinding

import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
//    private var mAppBarConfiguration: AppBarConfiguration? = null
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        val toolbar = findViewById<Toolbar>(R.id.main_toolbar)
//        setSupportActionBar(toolbar)
//        //        FloatingActionButton fab = findViewById(R.id.fab);
////        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
////                .setAction("Action", null).show());
//        val drawer = findViewById<DrawerLayout>(R.id.main_drawer_layout)
//        val navigationView = findViewById<NavigationView>(R.id.main_navigation_view)
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        mAppBarConfiguration = AppBarConfiguration.Builder(
//                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_about, R.id.nav_contact)
//                .setDrawerLayout(drawer)
//                .build()
//        val navController = Navigation.findNavController(this, R.id.main_nav_host)
//        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration!!)
//        NavigationUI.setupWithNavController(navigationView, navController)
//    }
//
//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.main, menu)
//        return true
//    }
//
//    override fun onSupportNavigateUp(): Boolean {
//        val navController = Navigation.findNavController(this, R.id.main_nav_host)
//        return (NavigationUI.navigateUp(navController, mAppBarConfiguration!!)
//                || super.onSupportNavigateUp())
//    }
private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController
    lateinit var drawerLayout: DrawerLayout
    lateinit var toolbar: Toolbar
    lateinit var bottomNavigationView: BottomNavigationView
    lateinit var navigationView: NavigationView
//    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        navController = findNavController(R.id.main_nav_host) //Initialising navController
        drawerLayout = findViewById(R.id.main_drawer_layout)
        toolbar = findViewById(R.id.main_toolbar)
        bottomNavigationView = findViewById(R.id.main_bottom_navigation_view)
        navigationView = findViewById(R.id.main_navigation_view)
        appBarConfiguration = AppBarConfiguration.Builder(R.id.nav_home, R.id.nav_rooms,R.id.nav_prices,
                R.id.nav_about, R.id.nav_contact, R.id.action_explore,R.id.action_inbox,R.id.action_account) //Pass the ids of fragments from nav_graph which you d'ont want to show back button in toolbar
                .setOpenableLayout(drawerLayout) //Pass the drawer layout id from activity xml
                .build()

        setSupportActionBar(toolbar) //Set toolbar

        setupActionBarWithNavController(navController, appBarConfiguration) //Setup toolbar with back button and drawer icon according to appBarConfiguration

        visibilityNavElements(navController) //If you want to hide drawer or bottom navigation configure that in this function
    }

    private fun visibilityNavElements(navController: NavController) {

        //Listen for the change in fragment (navigation) and hide or show drawer or bottom navigation accordingly if required
        //Modify this according to your need
        //If you want you can implement logic to deselect(styling) the bottom navigation menu item when drawer item selected using listener

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.bottom_profile -> hideBothNavigation()
                R.id.nav_about -> hideBottomNavigation()
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