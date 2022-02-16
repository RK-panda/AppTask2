package com.example.apptask2.home

import androidx.lifecycle.MutableLiveData
import com.example.apptask2.models.PostProduct
import com.example.apptask2.models.ReturnedResults
import com.example.apptask2.models.ShowProducts
import com.example.apptask2.retrofit.ApiClient
import com.example.apptask2.retrofit.ApiInterface
import retrofit2.Call
import retrofit2.Response
import retrofit2.create
import javax.security.auth.callback.Callback

class HomeRepository {
    private var apiInterface: ApiInterface?=null

    init {
        apiInterface = ApiClient.getRetrofitClient().create(ApiInterface::class.java)
    }

    fun getProductsData(): MutableLiveData<ReturnedResults<PostProduct>?> {
        val data = MutableLiveData<ReturnedResults<PostProduct>?>()
        apiInterface?.getProductsData()?.enqueue(object: Callback, retrofit2.Callback<ReturnedResults<PostProduct>> {

            override fun onResponse(call: Call<ReturnedResults<PostProduct>>, response: Response<ReturnedResults<PostProduct>>) {

                val responseBody = response.body()
                if(response.code() == 200 && responseBody!=null){
                    data.value = responseBody
                } else{
                    data.value = null
                }

            }

            override fun onFailure(call: Call<ReturnedResults<PostProduct>>, t: Throwable) {
                data.value = null
            }

        })
        return data
    }
}