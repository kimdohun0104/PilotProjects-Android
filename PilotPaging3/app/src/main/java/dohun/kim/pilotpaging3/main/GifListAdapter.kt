package dohun.kim.pilotpaging3.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import dohun.kim.pilotpaging3.databinding.ItemGifBinding
import dohun.kim.pilotpaging3.model.GifModel

class GifListAdapter :
    PagingDataAdapter<GifModel, GifListAdapter.GifHolder>(GifModel.DIFF_CALLBACK) {

    inner class GifHolder(private val binding: ItemGifBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val gif = getItem(position)
            binding.gif = gif
        }
    }

    override fun onBindViewHolder(holder: GifHolder, position: Int) = holder.bind(position)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifHolder =
        GifHolder(ItemGifBinding.inflate(LayoutInflater.from(parent.context), parent, false))

}