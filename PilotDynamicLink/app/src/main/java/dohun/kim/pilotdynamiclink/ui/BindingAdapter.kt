package dohun.kim.pilotdynamiclink.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dohun.kim.pilotdynamiclink.model.RepositoryModel
import dohun.kim.pilotdynamiclink.model.UserModel
import dohun.kim.pilotdynamiclink.ui.main.MainListAdapter
import dohun.kim.pilotdynamiclink.ui.repository.RepositoryListAdapter

@BindingAdapter("users")
fun RecyclerView.bindUsers(users: LiveData<List<UserModel>>) {
    users.value?.let {
        (this.adapter as MainListAdapter).submitList(it)
    }
}

@BindingAdapter("repositories")
fun RecyclerView.bindRepositories(repositories: LiveData<List<RepositoryModel>>) {
    repositories.value?.let {
        (this.adapter as RepositoryListAdapter).submitList(it)
    }
}

@BindingAdapter("imageUrl")
fun ImageView.bindImageUrl(imageUrl: String) {
    Glide.with(this).load(imageUrl).into(this)
}