package com.handeekin.sneakersapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
import com.handeekin.sneakersapp.entityy.CRUDResponse
import com.handeekin.sneakersapp.fragments.OpeningFragment
import com.handeekin.sneakersapp.repos.ItemsDAORepository
import com.handeekin.sneakersapp.retrofits.APIUtils
import com.handeekin.sneakersapp.retrofits.ItemsDAOInterface
import com.handeekin.sneakersapp.retrofits.UsersDAOInterface
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        udaoi = APIUtils.getUsersDaoInterface()
        idaoi = APIUtils.getItemsDaoInterface()

        val idaor = ItemsDAORepository()

        /*loadData()

        openingSignupButton.setOnClickListener {
            saveData()
        }
*/





        val bottomNav : BottomNavigationView = findViewById(R.id.bottomNavView)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment

        NavigationUI.setupWithNavController(bottomNav,navHostFragment.navController )


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