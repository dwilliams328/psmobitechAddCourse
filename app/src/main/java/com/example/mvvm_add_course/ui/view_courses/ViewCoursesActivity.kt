package com.example.mvvm_add_course.ui.view_courses

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_add_course.databinding.ActivityViewCoursesBinding
import com.example.mvvm_add_course.models.remote.ApiClient
import com.example.mvvm_add_course.models.remote.MainRepository

class ViewCoursesActivity : AppCompatActivity() {
    lateinit var binding: ActivityViewCoursesBinding
    lateinit var viewModel: ViewCoursesViewModel
    lateinit var adapter: ViewCoursesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewCoursesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()
        setUpRecyclerView()
        setupObservers()


    }

    private fun setUpRecyclerView() {
        val recyclerView = binding.recyclerView
        val layoutManager =
            LinearLayoutManager(this).apply { orientation = RecyclerView.HORIZONTAL }
        recyclerView.layoutManager = layoutManager
        adapter = ViewCoursesAdapter()
        recyclerView.adapter = adapter
    }

    private fun setupViewModel() {
        val repository = MainRepository(ApiClient.getApiHelper())
        val factory = ViewCoursesViewModelFactory(repository)

        viewModel = ViewModelProvider(this,factory).get(ViewCoursesViewModel::class.java)
    }

    private fun setupObservers() {
        //Log.d("abc", viewModel.getAllCourses().toString())

        viewModel.getAllCourses().observe(this, Observer {

            it?.let {

                when(it.status) {
                    0 ->{adapter.setData(it.courses)}
                    1 ->{}
                }
            }
        })

    }

}