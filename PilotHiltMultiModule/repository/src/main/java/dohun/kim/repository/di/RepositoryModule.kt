package dohun.kim.repository.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dohun.kim.model.UserRepository
import dohun.kim.repository.UserRepositoryImpl

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class RepositoryModule {

    @Binds
    @ActivityRetainedScoped
    abstract fun bindsUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository
}