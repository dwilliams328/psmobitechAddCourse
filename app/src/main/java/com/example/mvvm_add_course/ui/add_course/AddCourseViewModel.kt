package com.example.mvvm_add_course.ui.add_course

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_add_course.models.data.AddCourseRequest
import com.example.mvvm_add_course.models.data.AddCourseResponse
import com.example.mvvm_add_course.models.remote.MainRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.lang.Exception

class AddCourseViewModel(val mainRepository: MainRepository):ViewModel() {
    val titleError = MutableLiveData<String>()
    val descriptionError = MutableLiveData<String>()
    val feesError = MutableLiveData<String>()

    val addCourseResponse = MutableLiveData<AddCourseResponse>()

    fun addCourseRequest(addCourseRequest: AddCourseRequest){

        var hasError = false
        if(addCourseRequest.courseTitle.isEmpty()) {
            titleError.postValue("Please add title")
            hasError = true
        }

        if(addCourseRequest.courseDesc.isEmpty()) {
            descriptionError.postValue("provide description")
            hasError = true
        }

        if(addCourseRequest.courseFees.isEmpty()) {
            feesError.postValue("Please add fee")
            hasError = true
        }

        if(hasError) {
            return
        }

        viewModelScope.launch(IO) {
            try {
                val response = mainRepository.addCourse(addCourseRequest)

                if(response.isSuccessful){
                    addCourseResponse.postValue(response.body())
                }
                else{
                    addCourseResponse.postValue(AddCourseResponse("Failed to add Course, error code: ${response.code()}",1))
                }
            }
            catch (e: Exception){
                e.printStackTrace()
                addCourseResponse.postValue(AddCourseResponse("Failed to add Course, error code: ${e.message}",1))
            }

        }
    }
}