package com.example.mvvm_add_course.models.remote

import com.example.mvvm_add_course.models.data.AddCourseRequest

class MainRepository(val apiHelper: ApiHelper) {

    suspend fun addCourse(addCourseRequest: AddCourseRequest) = apiHelper.addCourse(addCourseRequest)


}