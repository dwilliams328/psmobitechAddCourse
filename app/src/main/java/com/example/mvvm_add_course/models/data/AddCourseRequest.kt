package com.example.mvvm_add_course.models.data

import com.google.gson.annotations.SerializedName

data class AddCourseRequest(
    @SerializedName("course_desc")
    val courseDesc: String,
    @SerializedName("course_fees")
    val courseFees: String,
    @SerializedName("course_title")
    val courseTitle: String
)