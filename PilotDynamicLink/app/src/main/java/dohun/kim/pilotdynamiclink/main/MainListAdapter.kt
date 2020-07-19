package dohun.kim.pilotdynamiclink.main

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dohun.kim.pilotdynamiclink.R
import dohun.kim.pilotdynamiclink.detail.DetailActivity
import dohun.kim.pilotdynamiclink.model.UserModel
import kotlinx.android.synthetic.main.item_user.view.*

class MainListAdapter :
    ListAdapter<UserModel, MainListAdapter.UserHolder>(UserModel.DIFF_CALLBACK) {

    inner class UserHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind() {
            val user = getItem(adapterPosition)
            itemView.tv_login.text = user.login
            Glide.with(itemView).load(user.avatarUrl).into(itemView.iv_avatar)
            itemView.setOnClickListener {
                it.context.startActivity(
                    Intent(it.context, DetailActivity::class.java),
                    bundleOf("login" to user.login)
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder =
        UserHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false))

    override fun onBindViewHolder(holder: UserHolder, position: Int) = holder.bind()
}