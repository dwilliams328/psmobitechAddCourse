package com.example.mvvm_add_course.ui.view_courses

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_add_course.R
import com.example.mvvm_add_course.databinding.ActivityAddCourseBinding
import com.example.mvvm_add_course.databinding.ActivityViewCoursesBinding
import com.example.mvvm_add_course.models.remote.ApiClient
import com.example.mvvm_add_course.models.remote.ApiHelper
import com.example.mvvm_add_course.models.remote.ApiService
import com.example.mvvm_add_course.models.remote.MainRepository

class ViewCoursesActivity : AppCompatActivity() {
    lateinit var binding: ActivityViewCoursesBinding
    lateinit var viewModel: ViewCoursesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewCoursesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()
        setupObservers()


    }

    private fun setupViewModel() {
        val repository = MainRepository(ApiClient.getApiHelper())
        val factory = ViewCoursesViewModelFactory(repository)

        viewModel = ViewModelProvider(this,factory).get(ViewCoursesViewModel::class.java)
    }

    private fun setupObservers() {
        //Log.d("abc", viewModel.getAllCourses().toString())




    }

}