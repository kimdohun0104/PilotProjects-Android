package dohun.kim.model

interface UserRepository {
    suspend fun getUsers(): List<UserModel>
}