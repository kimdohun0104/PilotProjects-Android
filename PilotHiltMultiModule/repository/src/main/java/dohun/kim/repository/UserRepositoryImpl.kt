package dohun.kim.repository

import dohun.kim.api.GithubService
import dohun.kim.model.UserModel
import dohun.kim.model.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val githubService: GithubService
) : UserRepository {
    override suspend fun getUsers(): List<UserModel> {
        // Do some caching
        return githubService.getUsers().map { it.toModel() }
    }
}