package org.sopt.santamanitto.user

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import org.sopt.santamanitto.user.data.controller.*
import org.sopt.santamanitto.user.data.source.FakeUserRemoteDataSource
import org.sopt.santamanitto.user.data.source.UserDataSource
import org.sopt.santamanitto.user.network.UserAuthService
import org.sopt.santamanitto.user.network.UserService
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class UserRemoteModule {

    @Provides
    @Singleton
    @Named("remote")
    fun provideUserRemoteDataSource() : UserDataSource = FakeUserRemoteDataSource()

    @Provides
    @Singleton
    fun provideUserAuthController(): UserAuthController = FakeUserAuthController()

    @Provides
    @Singleton
    fun provideUserController(): UserController = FakeUserController()
}