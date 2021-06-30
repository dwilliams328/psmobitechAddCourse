package com.example.mvvm_add_course.ui.add_course

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_add_course.models.remote.ApiClient
import com.example.mvvm_add_course.models.remote.MainRepository

class AddCourseViewModelFactory(val mainRepository: MainRepository): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AddCourseViewModel(mainRepository) as T
    }
}