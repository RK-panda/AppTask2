package com.example.apptask2.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.apptask2.models.PostProduct
import com.example.apptask2.models.ReturnedResults
import com.example.apptask2.models.ShowProducts

class HomeViewModel {



    private var homeRepository:HomeRepository?=null
    var postModelLiveData: LiveData<List<ReturnedResults<PostProduct>>>?=null

    init {
        homeRepository = HomeRepository()
        postModelLiveData = MutableLiveData()

    }

    fun getProductsData(){
        postModelLiveData = homeRepository?.getProductsData()
    }
}