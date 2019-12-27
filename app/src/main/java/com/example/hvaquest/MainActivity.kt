package com.example.hvaquest
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
