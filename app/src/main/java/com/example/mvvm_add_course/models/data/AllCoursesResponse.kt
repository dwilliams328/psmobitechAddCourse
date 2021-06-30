package com.example.mvvm_add_course.models.data

data class AllCoursesResponse(
    val courses: List<Course>?,
    val message: String,
    val status: Int
)

data class Course(
    val course_desc: String,
    val course_fees: String,
    val course_id: String,
    val course_title: String
)
