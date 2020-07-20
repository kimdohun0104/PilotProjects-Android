package dohun.kim.pilotdynamiclink.ui.main

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dohun.kim.pilotdynamiclink.databinding.ItemUserBinding
import dohun.kim.pilotdynamiclink.model.UserModel
import dohun.kim.pilotdynamiclink.ui.repository.RepositoryActivity

class MainListAdapter : ListAdapter<UserModel, MainListAdapter.UserHolder>(UserModel.DIFF_CALLBACK) {

    inner class UserHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val user = getItem(adapterPosition)
            binding.user = user

            itemView.setOnClickListener {
                Intent(it.context, RepositoryActivity::class.java).apply {
                    putExtra("login", user.login)
                    it.context.startActivity(this)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder =
        UserHolder(ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: UserHolder, position: Int) = holder.bind()
}