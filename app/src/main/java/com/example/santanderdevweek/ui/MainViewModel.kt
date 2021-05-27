package com.example.santanderdevweek.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.santanderdevweek.data.Account
import com.example.santanderdevweek.data.datalocal.FakeData

class MainViewModel :ViewModel(){

    private val mutableLiveData : MutableLiveData<Account> = MutableLiveData()

    fun buscarContaCliente() : LiveData<Account>{
        mutableLiveData.value = FakeData().getLocalData()

        return mutableLiveData
    }
}