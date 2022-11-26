package com.example.navigationexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.navigationexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // get the navController
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        // configure the app bar to include the up button
        //appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment))

        // configure the app bar to include the up button and navigation drawer
        //appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment), binding.drawerLayout)

        // configure the app bar to include the up button, bottom navigation and navigation drawer
        appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment, R.id.galleryFragment, R.id.slideshowFragment), binding.drawerLayout)

        setupActionBarWithNavController(navController, appBarConfiguration)

        //connect navigationview to navController
        binding.navView.setupWithNavController(navController)

        //connect bottom navigation to navController
        binding.bottomNavView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()

    }
}