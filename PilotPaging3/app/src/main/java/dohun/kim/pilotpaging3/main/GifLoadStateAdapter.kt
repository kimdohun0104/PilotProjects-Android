package dohun.kim.pilotpaging3.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import dohun.kim.pilotpaging3.databinding.ItemLoadingBinding


class GifLoadStateAdapter(
    private val retry: () -> Unit
) : LoadStateAdapter<GifLoadStateAdapter.LoadStateViewHolder>() {

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) =
        holder.bind(loadState)

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder =
        LoadStateViewHolder(
            ItemLoadingBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            retry
        )

    inner class LoadStateViewHolder(
        private val binding: ItemLoadingBinding,
        retry: () -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.btnRetry.setOnClickListener { retry() }
        }

        fun bind(loadState: LoadState) {
            binding.btnRetry.isVisible(loadState is LoadState.Error)
            binding.tvFailure.isVisible(loadState is LoadState.Error)
            binding.progressbar.isVisible(loadState is LoadState.Loading)
        }

        private fun View.isVisible(isVisible: Boolean) {
            this.visibility =
                if (isVisible) View.VISIBLE
                else View.GONE
        }
    }
}