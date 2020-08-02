package dohun.kim.pilotpaging3.model

import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName

data class GifModel(
    val id: String,
    @SerializedName("username")
    val userName: String,
    val title: String,
    val images: ImagesModel
) {
    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<GifModel>() {
            override fun areItemsTheSame(oldItem: GifModel, newItem: GifModel): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: GifModel, newItem: GifModel): Boolean =
                oldItem == newItem
        }
    }
}

data class ImagesModel(
    @SerializedName("fixed_width")
    val fixedWidth: FixedWidthModel
)

data class FixedWidthModel(
    val url: String,
    val height: Int
)