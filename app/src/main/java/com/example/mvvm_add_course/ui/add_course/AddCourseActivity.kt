package com.example.mvvm_add_course.ui.add_course

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_add_course.R
import com.example.mvvm_add_course.databinding.ActivityAddCourseBinding
import com.example.mvvm_add_course.models.data.AddCourseRequest
import com.example.mvvm_add_course.models.remote.ApiClient
import com.example.mvvm_add_course.models.remote.ApiHelper
import com.example.mvvm_add_course.models.remote.MainRepository

class AddCourseActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddCourseBinding
    lateinit var viewModel: AddCourseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddCourseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()
        setupObservers()
        setupEvents()

    }

    private fun setupViewModel() {
        val repository = MainRepository(ApiClient.getApiHelper())
        val factory = AddCourseViewModelFactory(repository)

        viewModel = ViewModelProvider(this,factory).get(AddCourseViewModel::class.java)
    }

    private fun setupObservers() {
        viewModel.titleError.observe(this) {
            binding.editTextCourseTitle.error = it
        }

        viewModel.descriptionError.observe(this) {
            binding.editTextCourseDescription.error = it
        }

        viewModel.feesError.observe(this) {
            binding.editTextCourseFees.error = it
        }

        viewModel.addCourseResponse.observe(this){
        Toast.makeText(baseContext,it.message,Toast.LENGTH_SHORT).show()
        }
    }


    private fun setupEvents() {
        binding.buttonAddNewCourse.setOnClickListener {
            val title = binding.editTextCourseTitle.text.toString()
            val description = binding.editTextCourseDescription.text.toString()
            val fees = binding.editTextCourseFees.text.toString()

            val addCourseRequest = AddCourseRequest(description,fees,title)

            viewModel.addCourseRequest(addCourseRequest)
        }
    }


}