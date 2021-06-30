package com.example.mvvm_add_course.ui.view_courses

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_add_course.models.data.AllCoursesResponse
import com.example.mvvm_add_course.models.remote.MainRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.lang.Exception

class ViewCoursesViewModel(val mainRepository: MainRepository):ViewModel() {

    private val allCoursesResponse = MutableLiveData<AllCoursesResponse>()

    fun fetchAllCourses(){
        viewModelScope.launch(IO) {
            try {
                val response = mainRepository.getAllCourses()

                if (response.isSuccessful){
                    allCoursesResponse.postValue(response.body())
                }
                else{
                    allCoursesResponse.postValue(AllCoursesResponse(null,"Error receiving Course, error code: ${response.code()}",1))
                }
            }
            catch (e: Exception){
                e.printStackTrace()
                allCoursesResponse.postValue(AllCoursesResponse(null,"Error receiving Course, error code: ${e.message}",1))
            }
        }
    }

    fun getAllCourses():LiveData<AllCoursesResponse>{
        fetchAllCourses()

        return allCoursesResponse
    }
}