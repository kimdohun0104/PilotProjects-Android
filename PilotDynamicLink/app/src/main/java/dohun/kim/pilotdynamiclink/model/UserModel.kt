package dohun.kim.pilotdynamiclink.model

import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName

data class UserModel(
    val login: String,
    val id: Int,
    @SerializedName( "avatar_url")
    val avatarUrl: String
) {
    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<UserModel>() {
            override fun areItemsTheSame(oldItem: UserModel, newItem: UserModel): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: UserModel, newItem: UserModel): Boolean =
                oldItem.avatarUrl == newItem.avatarUrl && oldItem.login == newItem.login
        }
    }
}