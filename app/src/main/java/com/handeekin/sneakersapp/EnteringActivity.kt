package com.handeekin.sneakersapp

import android.content.Intent
import android.content.SharedPreferences
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

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entering)

        openingSignupButton.setOnClickListener {
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }



        openingLoginButton.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }

    }

