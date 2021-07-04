package com.handeekin.sneakersapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.navigation.NavAction
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.handeekin.sneakersapp.databinding.ActivityMainBinding
import com.handeekin.sneakersapp.entityy.CRUDResponse
import com.handeekin.sneakersapp.fragments.OpeningFragment
import com.handeekin.sneakersapp.repos.ItemsDAORepository
import com.handeekin.sneakersapp.retrofits.APIUtils
import com.handeekin.sneakersapp.retrofits.ItemsDAOInterface
import com.handeekin.sneakersapp.retrofits.UsersDAOInterface
import kotlinx.android.synthetic.main.activity_entering.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_opening.*
import kotlinx.android.synthetic.main.fragment_sign_up.*
import kotlinx.android.synthetic.main.fragment_user_info.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var udaoi: UsersDAOInterface
    private lateinit var idaoi: ItemsDAOInterface
    lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        sharedPreferences = getSharedPreferences("Shared_pref",Context.MODE_PRIVATE)


        udaoi = APIUtils.getUsersDaoInterface()
        idaoi = APIUtils.getItemsDaoInterface()

        val idaor = ItemsDAORepository()

        /*loadData()

        openingSignupButton.setOnClickListener {
            saveData()
        }

*//*
        signUpButton.setOnClickListener {
            val name : String = editTextNameSurnamef.text.toString()
            val phone : String = editTextPhoneNumberf.text.toString()
            val mail : String = editTextEmailSignf.text.toString()

            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("NAME",name)
            editor.putString("PHONE",phone)
            editor.putString("MAIL",mail)
            editor.apply()

            Toast.makeText(this,"Succesfully signed up!",Toast.LENGTH_SHORT).show()

        }
*/




        val bottomNav : BottomNavigationView = findViewById(R.id.bottomNavView)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment

        NavigationUI.setupWithNavController(bottomNav,navHostFragment.navController )

        navHostFragment.navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when(destination.id){
                R.id.openingFragment -> hideBottomNav()
                R.id.signUpFragment -> hideBottomNav()
                else -> showBottomNav()
            }
        }



    }

    fun showBottomNav() {
        bottomNavView.visibility = View.VISIBLE

    }

    fun hideBottomNav() {
        bottomNavView.visibility = View.GONE

    }

   /* private fun saveData(){
        val insertedTextName = editTextNameSurname.text.toString()
        val insertedTextMail = editTextNameSurname.text.toString()
        val insertedTextPhone = editTextNameSurname.text.toString()
        textinfoNameSurname = insertedTextName
        textinfoMail = insertedTextMail
        textinfoPhoneNumber = insertedTextPhone

        val sharedPreferences = getSharedPreferences("sharedPrefs",Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply{
            putString("STRING_NAME", insertedTextName)
            putString("STRING_MAIL", insertedTextMail)
            putString("STRING_PHONE", insertedTextPhone)
        }.apply()
    }

*/
}