package dohun.kim.pilothilt

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dohun.kim.pilothilt.main.UserListAdapter
import dohun.kim.pilothilt.model.UserModel

@BindingAdapter("imageUrl")
fun ImageView.bindImageUrl(url: String?) {
    Glide.with(this).load(url).into(this)
}

@BindingAdapter("users")
fun RecyclerView.bindUsers(usersLiveData: LiveData<List<UserModel>>) {
    usersLiveData.value?.let {
        (adapter as UserListAdapter).submitList(it)
    }
}