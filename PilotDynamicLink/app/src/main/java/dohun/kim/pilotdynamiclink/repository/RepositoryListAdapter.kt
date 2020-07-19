package dohun.kim.pilotdynamiclink.repository

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dohun.kim.pilotdynamiclink.R
import dohun.kim.pilotdynamiclink.model.RepositoryModel
import kotlinx.android.synthetic.main.item_repository.view.*

class RepositoryListAdapter :
    ListAdapter<RepositoryModel, RepositoryListAdapter.RepositoryHolder>(RepositoryModel.DIFF_CALLBACK) {

    inner class RepositoryHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind() {
            val repository = getItem(adapterPosition)
            itemView.tv_full_name.text = repository.fullName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryHolder =
        RepositoryHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_repository, parent, false)
        )

    override fun onBindViewHolder(holder: RepositoryHolder, position: Int) = holder.bind()


}