package dohun.kim.pilotpaging3

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun ImageView.bindImageUrl(imageUrl: String) {
    Glide.with(this)
        .load(imageUrl)
        .placeholder(R.drawable.ic_launcher_background)
        .into(this)
}