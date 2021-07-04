package com.handeekin.sneakersapp

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.handeekin.sneakersapp.databinding.FragmentSignUpBinding
import com.handeekin.sneakersapp.fragments.SignUpFragmentDirections
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.fragment_sign_up.*
import kotlinx.android.synthetic.main.fragment_sign_up.signUpButton

class SignUpActivity : AppCompatActivity() {

    private lateinit var tasarim: FragmentSignUpBinding
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)



        signUpButton.setOnClickListener {
            val gecis = SignUpFragmentDirections.signuptologingecis()
            Navigation.findNavController(it).navigate(gecis)
        }


        signUpButton.setOnClickListener {
            val name : String = editTextNameSurnameSign.text.toString()
            val phone : String = editTextPhoneNumberSign.text.toString()
            val mail : String = editTextEmailSign.text.toString()

            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("NAME",name)
            editor.putString("PHONE",phone)
            editor.putString("MAIL",mail)
            editor.apply()

            Toast.makeText(this,"Succesfully signed up!", Toast.LENGTH_SHORT).show()

            val intent = Intent(this,EnteringActivity::class.java)
            startActivity(intent)
        }


    }
}