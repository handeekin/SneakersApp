package com.handeekin.sneakersapp

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

        /*salesItemChange(706,1)
        salesItemChange(700,1)
        salesItemChange(697,1)
*/




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

    fun salesItemChange(id: Int,urun_indirimli_mi :Int) {
        idaoi.change_sales_item(id,urun_indirimli_mi).enqueue(object :
            Callback<CRUDResponse?> {
            override fun onResponse(call: Call<CRUDResponse?>, response: Response<CRUDResponse?>) {
                Log.e("response",response.body()!!.success.toString())
                Log.e("mesaj", response.body()!!.message)
            }
            override fun onFailure(call: Call<CRUDResponse?>, t: Throwable) {}
        })
    }
}