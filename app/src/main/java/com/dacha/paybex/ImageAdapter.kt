package com.dacha.paybex

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.dacha.paybex.databinding.ItemImageBinding

class ImageAdapter(val list : ArrayList<ImageModel>) : RecyclerView.Adapter<ImageAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemImageBinding.inflate(LayoutInflater.from(parent.context),
            parent ,
            false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun addImage(Image : ImageModel) {
        list.add(Image)
    }


    class ViewHolder(val binding: ItemImageBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(imageModel: ImageModel) {
            binding.iv.load(imageModel.largeImageURL)
        }

    }

}