package dohun.kim.pilothiltmultimodule

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dohun.kim.model.UserModel
import dohun.kim.pilothiltmultimodule.main.UserListAdapter

@BindingAdapter("users")
fun RecyclerView.bindUsers(usersLiveData: LiveData<List<UserModel>>) {
    usersLiveData.value?.let {
        (adapter as UserListAdapter).submitList(it)
    }
}

@BindingAdapter("imageUrl")
fun ImageView.bindImageUrl(imageUrl: String) {
    Glide.with(this).load(imageUrl).into(this)
}