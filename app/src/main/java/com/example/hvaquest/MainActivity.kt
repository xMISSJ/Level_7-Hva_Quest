package com.example.hvaquest

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.hvaquest.ViewModel.QuestViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: QuestViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = ViewModelProviders.of(this).get(QuestViewModel::class.java)

        initNavigation();
    }

    private fun initNavigation(){

        // Navigation Controller.
        val navController = findNavController(R.id.navHostFragment);

        // Connect startFragment with the Toolbar.
        val appBarConfiguration = AppBarConfiguration(navController.graph);

        // Sets up the ActionBar returned by AppCompatActivity#getSupportActionBar() for use with a NavController.
        // Title in the action bar is automatically updated by calling setupActionBarWithNavController.
        // The start destination of your navigation graph is considered the only top level destination.
        // Actionbar will only show up arrow in destinations other than the main.
        // Call navigateUp(NavController, DrawerLayout) to handle the Up button.
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = findNavController(R.id.navHostFragment)
        when (item?.itemId) {
            android.R.id.home -> {
                // Check whether there is a progress in the quest.
                if (viewModel.questIndexTracker > 0) {
                    viewModel.questIndexTracker -= 1;
                }
                // Navigate up in the hierarchy of fragments.
                navController.navigateUp();
                return true
            }
        }
            return super.onOptionsItemSelected(item);
    }

}
