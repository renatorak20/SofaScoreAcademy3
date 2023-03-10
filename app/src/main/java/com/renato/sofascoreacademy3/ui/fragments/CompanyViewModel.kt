package com.renato.sofascoreacademy3.ui.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.renato.sofascoreacademy3.entities.Company

class CompanyViewModel : ViewModel() {
    private val _companies = MutableLiveData<List<Company>>()
    val companies : LiveData<List<Company>> = _companies

    fun addCompany(company: Company) {
        val list = companies.value?.toMutableList() ?: mutableListOf()
        list.add(company)
        _companies.value = list
    }

    fun getList(): MutableLiveData<List<Company>> {
        return _companies
    }
}
