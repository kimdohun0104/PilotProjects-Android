package dohun.kim.pilothiltmultimodule.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dohun.kim.model.UserModel
import dohun.kim.model.UserRepository
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _users = MutableLiveData<List<UserModel>>()
    val users: LiveData<List<UserModel>> = _users

    init {
        getUsers()
    }

    private fun getUsers() = viewModelScope.launch {
        _users.value = userRepository.getUsers()
    }
}