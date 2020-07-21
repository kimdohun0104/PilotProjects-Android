package dohun.kim.pilothilt.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.android.scopes.ActivityScoped
import dohun.kim.pilothilt.data.UserRepository
import dohun.kim.pilothilt.data.UserRepositoryImpl

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class RepositoryModule {

    @Binds
    @ActivityRetainedScoped
    abstract fun bindsUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository
}