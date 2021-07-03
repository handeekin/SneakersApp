package com.handeekin.sneakersapp.repos

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.handeekin.sneakersapp.entityy.CRUDResponse
import com.handeekin.sneakersapp.entityy.UsersClass
import com.handeekin.sneakersapp.entityy.UsersResponse
import com.handeekin.sneakersapp.retrofits.APIUtils
import com.handeekin.sneakersapp.retrofits.UsersDAOInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserDAORepository {
    private val userList:MutableLiveData<List<UsersClass>> = MutableLiveData()
    private val userVal: MutableLiveData<Int> = MutableLiveData()
    private val udaoi: UsersDAOInterface = APIUtils.getUsersDaoInterface()


    fun getUserVal(): MutableLiveData<Int>{
        return userVal
    }

    fun userValidation(): MutableLiveData<List<UsersClass>>{
        return userList
    }
    fun getUser(mail_adres:String,sifre:String){
        udaoi.logIn(mail_adres,sifre).enqueue(object:Callback<UsersResponse>{
            override fun onFailure(call: Call<UsersResponse>, t: Throwable) {
                Log.e("getUser",t?.localizedMessage.toString())
            }

            override fun onResponse(call: Call<UsersResponse>?, response: Response<UsersResponse>) {
                Log.e("başarı", response.body()!!.users.toString())
                val usersList_ = response.body()!!.users
                userList.value= usersList_
                val userVal_ = response.body()!!.users[0].user_val
                userVal.value = userVal_
                println("liste size: " + userList.value!!.size)
                println("kullanici adi: " + userList.value!![0].nameSurname)
                println("kullanici deger: " + userVal.value!!)


            }
        })
    }

    fun addUser(mail_adres: String,sifre: String,ad_soyad:String,telefon:String){
        udaoi.signUp(mail_adres, sifre, ad_soyad, telefon).enqueue(object :Callback<CRUDResponse>{
            override fun onResponse(call: Call<CRUDResponse>?, response: Response<CRUDResponse>) {
                Log.e("başarı",response.body()!!.success.toString())
                Log.e("Mesaj",response.body()!!.message)
            }

            override fun onFailure(call: Call<CRUDResponse>, t: Throwable) {
                Log.e(  "addUser",t?.localizedMessage.toString())
            }
        })
    }
}