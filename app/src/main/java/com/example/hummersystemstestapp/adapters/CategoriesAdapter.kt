package com.example.hummersystemstestapp.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hummersystemstestapp.R
import com.example.hummersystemstestapp.data.models.CategoryItem
import com.example.hummersystemstestapp.inflate
import kotlinx.android.synthetic.main.item_category.view.*

class CategoriesAdapter : RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder>() {
    private var categoryList = emptyList<CategoryItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = parent.inflate(R.layout.item_category)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val currentItem = categoryList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    fun setData(bannerList: List<CategoryItem>) {
        this.categoryList = bannerList
    }

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(categoryItem: CategoryItem) {
            itemView.textViewCategoryName.text = categoryItem.name
        }
    }
}