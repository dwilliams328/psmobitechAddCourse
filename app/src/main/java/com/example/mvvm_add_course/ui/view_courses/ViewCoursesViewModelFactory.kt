package com.example.mvvm_add_course.ui.view_courses

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_add_course.models.remote.MainRepository

class ViewCoursesViewModelFactory(val mainRepository: MainRepository): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ViewCoursesViewModel(mainRepository) as T
    }
}