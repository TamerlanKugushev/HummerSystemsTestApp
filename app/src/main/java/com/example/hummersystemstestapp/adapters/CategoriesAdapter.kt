package com.example.hummersystemstestapp.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide.init
import com.example.hummersystemstestapp.R
import com.example.hummersystemstestapp.data.models.CategoryItem
import com.example.hummersystemstestapp.extensions.inflate
import kotlinx.android.synthetic.main.item_category.view.*

class CategoriesAdapter(onCategoryClickListener: OnCategoryClickListener) :
    RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder>() {

    private var categoryList = emptyList<CategoryItem>()
    private var onCategoryClickListener: OnCategoryClickListener? = null

    init {
        this.onCategoryClickListener = onCategoryClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = parent.inflate(R.layout.item_category)
        return CategoryViewHolder(view,onCategoryClickListener)
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

    class CategoryViewHolder(itemView: View, onCategoryClickListener: OnCategoryClickListener?) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var onCategoryClickListener: OnCategoryClickListener? = null

        init {
            itemView.setOnClickListener(this)
            this.onCategoryClickListener = onCategoryClickListener
        }

        fun bind(categoryItem: CategoryItem) {
            itemView.textViewCategoryName.text = categoryItem.name
        }

        override fun onClick(v: View?) {
            onCategoryClickListener?.onCategoryClick(adapterPosition)
        }
    }

    interface OnCategoryClickListener {
        fun onCategoryClick(position: Int)
    }
}