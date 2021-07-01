package com.handeekin.sneakersapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.handeekin.sneakersapp.Retrofit.APIUtils
import com.handeekin.sneakersapp.Retrofit.ItemsUsersDAOInterface

class MainActivity : AppCompatActivity() {
    private lateinit var iudaoi: ItemsUsersDAOInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iudaoi = APIUtils.getItemsDaoInterface()




        val toolbar : Tool


        val bottomNav : BottomNavigationView = findViewById(R.id.bottomNavView)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment

        NavigationUI.setupWithNavController(bottomNav,navHostFragment.navController )


    }
}