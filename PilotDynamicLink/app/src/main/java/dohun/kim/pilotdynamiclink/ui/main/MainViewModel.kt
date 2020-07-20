package dohun.kim.pilotdynamiclink.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dohun.kim.pilotdynamiclink.data.GithubService
import dohun.kim.pilotdynamiclink.model.UserModel
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _users = MutableLiveData<List<UserModel>>()
    val users: LiveData<List<UserModel>> = _users

    init {
        getUsers()
    }

    private fun getUsers() = viewModelScope.launch {
        _users.value = GithubService.getService().getUsers()
    }
}