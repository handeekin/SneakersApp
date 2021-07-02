package com.handeekin.sneakersapp.retrofits

class APIUtils {
    companion object{

        val BASE_URL = "http://upschool.canerture.com/"

        fun getItemsDaoInterface(): ItemsDAOInterface {
            return RetrofitClient.getClient(BASE_URL).create(ItemsDAOInterface::class.java)
        }

        fun getUsersDaoInterface(): UsersDAOInterface {
            return RetrofitClient.getClient(BASE_URL).create(UsersDAOInterface::class.java)
        }
    }
}