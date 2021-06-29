package com.handeekin.sneakersapp.Retrofit

class APIUtils {
    companion object{

        val BASE_URL = "http://upschool.canerture.com/"

        fun getItemsDaoInterface(): ItemsUsersDAOInterface {
            return RetrofitClient.getClient(BASE_URL).create(ItemsUsersDAOInterface::class.java)
        }
    }
}