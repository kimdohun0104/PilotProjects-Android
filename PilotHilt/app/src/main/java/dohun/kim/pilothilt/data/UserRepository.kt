package dohun.kim.pilothilt.data

import dohun.kim.pilothilt.model.UserModel
import javax.inject.Inject

interface UserRepository {
    suspend fun getUsers(): List<UserModel>
}

class UserRepositoryImpl @Inject constructor(
    private val githubService: GithubService
) : UserRepository {

    override suspend fun getUsers(): List<UserModel> {
        // Caching happens here
        return githubService.getUsers()
    }

}