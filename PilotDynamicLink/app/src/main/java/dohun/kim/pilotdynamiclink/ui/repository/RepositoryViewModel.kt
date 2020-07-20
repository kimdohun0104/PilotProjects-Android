package dohun.kim.pilotdynamiclink.ui.repository

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dohun.kim.pilotdynamiclink.DynamicLinkUtil
import dohun.kim.pilotdynamiclink.data.GithubService
import dohun.kim.pilotdynamiclink.model.RepositoryModel
import kotlinx.coroutines.launch

class RepositoryViewModel : ViewModel() {
    private val _login = MutableLiveData<String>()
    val login: LiveData<String> = _login

    private val _repositories = MutableLiveData<List<RepositoryModel>>()
    val repositories: LiveData<List<RepositoryModel>> = _repositories

    private val _shortUri = MutableLiveData<Uri>()
    val shortUri: LiveData<Uri> = _shortUri

    fun getLogin(login: String?, intent: Intent) = viewModelScope.launch {
        _login.value =
            if (login.isNullOrBlank()) DynamicLinkUtil.getDynamicLink(intent)
            else login
    }

    fun getRepositories() = viewModelScope.launch {
        _repositories.value = GithubService.getService().getRepositories(login.value ?: "")
    }

    fun createDynamicLink() = viewModelScope.launch {
        _shortUri.value = DynamicLinkUtil.createDynamicLink(login.value ?: "")
    }
}