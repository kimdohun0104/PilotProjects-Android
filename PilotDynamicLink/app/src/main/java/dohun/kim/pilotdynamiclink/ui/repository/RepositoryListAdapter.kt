package dohun.kim.pilotdynamiclink.ui.repository

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dohun.kim.pilotdynamiclink.databinding.ItemRepositoryBinding
import dohun.kim.pilotdynamiclink.model.RepositoryModel

class RepositoryListAdapter :
    ListAdapter<RepositoryModel, RepositoryListAdapter.RepositoryHolder>(RepositoryModel.DIFF_CALLBACK) {

    inner class RepositoryHolder(private val binding: ItemRepositoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val repository = getItem(adapterPosition)
            binding.repository = repository
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryHolder =
        RepositoryHolder(ItemRepositoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: RepositoryHolder, position: Int) = holder.bind()
}