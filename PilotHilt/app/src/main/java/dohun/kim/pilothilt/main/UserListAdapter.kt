package dohun.kim.pilothilt.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dohun.kim.pilothilt.databinding.ItemUserBinding
import dohun.kim.pilothilt.model.UserModel

class UserListAdapter :
    ListAdapter<UserModel, UserListAdapter.UserViewHolder>(UserModel.CALL_BACK) {

    inner class UserViewHolder(
        private val binding: ItemUserBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.user = getItem(adapterPosition)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder =
        UserViewHolder(ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind()
    }

}