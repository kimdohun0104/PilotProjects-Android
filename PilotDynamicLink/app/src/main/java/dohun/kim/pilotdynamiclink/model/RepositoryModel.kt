package dohun.kim.pilotdynamiclink.model

import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName

data class RepositoryModel(

    val id: Int,

    val name: String,

    @SerializedName("full_name")
    val fullName: String,

    val private: Boolean
) {
    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<RepositoryModel>() {
            override fun areItemsTheSame(oldItem: RepositoryModel, newItem: RepositoryModel): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: RepositoryModel, newItem: RepositoryModel): Boolean =
                oldItem.private == newItem.private && oldItem.fullName == newItem.fullName && newItem.name == oldItem.name

        }
    }
}