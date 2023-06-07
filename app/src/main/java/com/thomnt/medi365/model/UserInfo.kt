package com.thomnt.medi365.model

import com.thomnt.medi365.R

data class UserInfo(
    var avatar: Int? = null,

    var fullName: String? = null,

    var phoneNumber: String? = null
)

fun mockUserInfo(): UserInfo{
    return UserInfo().apply {
        avatar = R.drawable.ic_avatar_default
        fullName = "Lê Thị Na"
        phoneNumber ="0123456789"
    }
}
