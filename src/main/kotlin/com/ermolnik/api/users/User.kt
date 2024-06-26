package com.ermolnik.api.users

import com.ermolnik.db.serializer.KOffsetDateTimeSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.OffsetDateTime

@Serializable
data class CreateUserRequest(
    @SerialName("username")
    val username: String,

    @SerialName("password")
    val password: String,

    @SerialName("full_name")
    val fullName: String,

    @SerialName("email")
    val email: String,
)

@Serializable
data class CreateUserResponse(
    @SerialName("username")
    val username: String,
)

@Serializable
data class UserResponse(
    @SerialName("username")
    val username: String,

    @SerialName("full_name")
    val fullName: String,

    @SerialName("email")
    val email: String,

    @SerialName("password_changed_at")
    @Serializable(with = KOffsetDateTimeSerializer::class)
    val passwordChangedAt: OffsetDateTime,

    @SerialName("created_at")
    @Serializable(with = KOffsetDateTimeSerializer::class)
    val createdAt: OffsetDateTime,
)

@Serializable
data class RegisterUserRequest(
    @SerialName("username")
    val username: String,

    @SerialName("password")
    val password: String,

    @SerialName("full_name")
    val fullName: String,

    @SerialName("email")
    val email: String,
)

@Serializable
data class LoginUserRequest(
    @SerialName("username")
    val username: String,

    @SerialName("password")
    val password: String
)

@Serializable
data class LoginUserResponse(
    @SerialName("access_token")
    val accessToken: String,

    @SerialName("user")
    val user: UserResponse,
)