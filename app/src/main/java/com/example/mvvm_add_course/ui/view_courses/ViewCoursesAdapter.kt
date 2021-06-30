package com.example.mvvm_add_course.ui.view_courses

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_add_course.models.data.Course

class ViewCoursesAdapter : RecyclerView.Adapter<ViewCoursesAdapter.ItemViewHolder>() {

    private var courses: List<Course>? = null

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return courses?.let { courses!!.size } ?: 0
    }

    fun setData(it: List<Course>?) {
      this.courses = it
        notifyDataSetChanged()
    }
}