package com.example.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.list.databinding.ItemListBinding
import com.example.core_android.network.api.model.characters.Character

class ListAdapter : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    private val listItems: MutableList<Character?> = mutableListOf()

    inner class ViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Character?) {
            binding.item1.text = item?.name
            binding.item1.text = item?.description
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = listItems.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(listItems[position])

    fun updateList(character: List<Character>?) {
        character?.toMutableList()?.let { listItems.addAll(it) }
    }
}