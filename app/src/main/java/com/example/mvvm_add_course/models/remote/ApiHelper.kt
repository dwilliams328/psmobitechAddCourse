package com.example.mvvm_add_course.models.remote

import com.example.mvvm_add_course.models.data.AddCourseRequest

class ApiHelper(val ApiService: ApiService) {

    suspend fun addCourse(AddCourseRequest:AddCourseRequest) = ApiService.addCourse(AddCourseRequest)
}