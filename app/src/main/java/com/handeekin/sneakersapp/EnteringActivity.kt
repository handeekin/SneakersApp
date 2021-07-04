package com.handeekin.sneakersapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import com.handeekin.sneakersapp.databinding.FragmentOpeningBinding
import com.handeekin.sneakersapp.entityy.UsersClass
import com.handeekin.sneakersapp.fragments.OpeningFragment
import com.handeekin.sneakersapp.fragments.SignUpFragment
import com.handeekin.sneakersapp.repos.UserDAORepository
import com.handeekin.sneakersapp.retrofits.APIUtils
import com.handeekin.sneakersapp.retrofits.UsersDAOInterface
import com.handeekin.sneakersapp.viewmodels.OpeningFragmentViewModel
import kotlinx.android.synthetic.main.activity_entering.*
import kotlinx.android.synthetic.main.fragment_sign_up.*

class EnteringActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entering)

        var udaoi: UsersDAOInterface
        var tasarim: FragmentOpeningBinding
        lateinit var viewModel: OpeningFragmentViewModel

        udaoi = APIUtils.getUsersDaoInterface()

        val udaor = UserDAORepository()
        var success = MutableLiveData<Int>()
        var user = MutableLiveData<List<UsersClass>>()

        openingSignupButton.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        viewModel.user.observe(this){
            if (it[0].user_val == 1){
                val sharedPreferences = getSharedPreferences("com.handeekin.sneakersapp",
                    MODE_PRIVATE)
                val editor =sharedPreferences.edit()
                editor.apply{
                    putInt("INT_USER_ID",it[0].user_val)
                    putString("STRING_NAME",it[0].nameSurname)
                    putString("STRING_MAIL",it[0].mailAdress)
                    putString("STRING_PHONE",it[0].telephone)
                }.apply()
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)

            }
            else{
                Toast.makeText(this,"Wrong e-mail or password.",Toast.LENGTH_SHORT).show()
            }

        }

        openingLoginButton.setOnClickListener {

            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)

        }

        fun buttonLoginClicked(mail_adres:String,sifre:String){
            viewModel.login(mail_adres,sifre)

        }
    }

    }

