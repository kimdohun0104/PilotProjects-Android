package dohun.kim.pilotpaging3.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import dohun.kim.pilotpaging3.R


class GifLoadStateAdapter : LoadStateAdapter<GifLoadStateAdapter.LoadStateViewHolder>() {

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) =
        holder.bind(loadState)

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder =
        LoadStateViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_loading, parent, false)
        )

    inner class LoadStateViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(loadState: LoadState) {

        }
    }
}