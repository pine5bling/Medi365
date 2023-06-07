package com.thomnt.medi365.model

import com.thomnt.medi365.R

data class MEP(
    var image: Int? = null,
    var name: String? = null,
    var clinicName: String? = null,
    var watchNumber: Int? = null,
    var cartNumber: Int? = null,
    var gender: String? = null,
    var currentPrice: Long? = null,
    var previousPrice: Long? = null
)

fun mockMEP(): MEP {
    return MEP().apply {
        image = R.drawable.ic_mep
        name = "Gói khám sức khỏe tổng quát"
        clinicName = "Phòng khám đa khoa Hoàng Long"
        watchNumber = 100
        cartNumber = 8
        gender = "Nam/Nữ "
        currentPrice = 1000000
        previousPrice = 2000000
    }
}

fun mockMEPList(): MutableList<MEP> {
    val mepList = mutableListOf<MEP>()
    for (i in 0..5) {
        mepList.add(mockMEP())
    }
    return mepList
}

