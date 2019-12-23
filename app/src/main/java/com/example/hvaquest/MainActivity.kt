package com.example.hvaquest

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(toolbar);

        initNavigation();
    }

    private fun initNavigation(){
        // Navigation Controller.
        val navController = findNavController(R.id.navHostFragment);

        // Connect startFragment with the Toolbar.
        val appBarConfiguration = AppBarConfiguration(navController.graph);
        appBarConfiguration.topLevelDestinations.add(R.id.startFragment);
    }
}
