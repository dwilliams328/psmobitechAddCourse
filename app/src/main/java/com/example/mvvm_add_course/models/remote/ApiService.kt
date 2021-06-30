package com.example.mvvm_add_course.models.remote

import com.example.mvvm_add_course.models.data.AddCourseRequest
import com.example.mvvm_add_course.models.data.AddCourseResponse
import com.example.mvvm_add_course.models.data.AllCoursesResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {

    @Headers("Content-type:application/json")
    @POST("Course/addCourse")
    suspend fun addCourse(@Body addCourseRequest: AddCourseRequest):Response<AddCourseResponse>

    @Headers("Content-type:application/json")
    @GET("Course/getCourses")
    suspend fun getAllCourses(): Response<AllCoursesResponse>

}