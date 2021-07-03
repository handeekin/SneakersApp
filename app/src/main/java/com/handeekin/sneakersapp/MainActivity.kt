package com.handeekin.sneakersapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.WindowManager
import androidx.appcompat.widget.SearchView
import androidx.navigation.NavAction
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.handeekin.sneakersapp.fragments.OpeningFragment
import com.handeekin.sneakersapp.retrofits.APIUtils
import com.handeekin.sneakersapp.retrofits.UsersDAOInterface
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var udaoi: UsersDAOInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        udaoi = APIUtils.getUsersDaoInterface()





        val bottomNav : BottomNavigationView = findViewById(R.id.bottomNavView)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment

        NavigationUI.setupWithNavController(bottomNav,navHostFragment.navController )


       /* val toolbarIcon : MenuItem = findViewById(R.id.action_cart)

        NavigationUI.setupWithNavController(toolbarIcon,navHostFragment.navController)*/

       /* override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
            inflater.inflate(R.menu.toolbar_menu,menu)

            val item = menu.findItem(R.id.action_cart)
            val navAct = item.actionView as NavAction
            navAct.setOnQueryTextListener(this)

            super.onCreateOptionsMenu(menu, inflater)
        }*/

    }
}