package com.example.list.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.core_android.network.api.model.characters.Character
import com.example.list.databinding.ItemListBinding

class ListAdapter : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<Character>() {
        override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

        override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem.id == newItem.id && oldItem.name == newItem.name && oldItem.description == newItem.description && oldItem.thumbnail?.path == newItem.thumbnail?.path && oldItem.thumbnail?.extension == newItem.thumbnail?.extension
        }

    }

    private val differ = AsyncListDiffer(this, diffCallback)

    var listItems: List<Character>?
        get() = differ.currentList
        set(value) = differ.submitList(value)

    inner class ViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Character?, context:Context) {
            binding.apply {
                name.text = item?.name
                description.text = if (!item?.description.isNullOrBlank()) {
                    item?.description
                } else {
                    "não possui descrição"
                }
                val urlImage = item?.thumbnail?.path+"."+item?.thumbnail?.extension
                val urlFormat = urlImage.replace("http","https")
                Glide.with(context)
                    .load(urlFormat)
                    .into(imageView);
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemListBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ),
        )
    }

    override fun getItemCount(): Int = listItems?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listItems?.get(position), holder.itemView.context)
    }


}