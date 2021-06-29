package com.example.hummersystemstestapp.adapters

import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.hummersystemstestapp.R
import com.example.hummersystemstestapp.data.models.CategoryItem
import com.example.hummersystemstestapp.extensions.inflate
import kotlinx.android.synthetic.main.item_category.view.*

class CategoriesAdapter(
    private val onCategoryClick: (position: Int) -> Unit
) : RecyclerView.Adapter<CategoryViewHolder>() {

    private var categoryList = emptyList<CategoryItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = parent.inflate(R.layout.item_category)
        return CategoryViewHolder(view, onCategoryClick)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val currentItem = categoryList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    fun setData(categories: List<CategoryItem>) {
        this.categoryList = categories
        notifyDataSetChanged()
    }

}

class CategoryViewHolder(
    itemView: View,
    onCategoryClick: (position: Int) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    init {
        itemView.setOnClickListener {
            onCategoryClick.invoke(adapterPosition)
        }
    }

    fun bind(categoryItem: CategoryItem) {
        itemView.textViewCategoryName.text = categoryItem.name
        if (categoryItem.isPressed) {
            itemView.textViewCategoryName.setBackgroundResource(R.drawable.ic_category_bg_active)
            itemView.textViewCategoryName.setTextColor(getColor(R.color.category_btn_txt_active))
        } else {
            itemView.textViewCategoryName.setBackgroundResource(R.drawable.ic_category_bg_passive)
            itemView.textViewCategoryName.setTextColor(getColor(R.color.category_btn_txt_passive))
        }
    }


    private fun getColor(@ColorRes id: Int): Int {
        return ResourcesCompat.getColor(itemView.resources, id, itemView.context.theme)
    }

}

