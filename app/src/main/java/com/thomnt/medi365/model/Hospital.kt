package com.thomnt.medi365.model

import com.thomnt.medi365.R

data class Hospital(
    var image: Int? = null,
    var name: String? = null,
    var address: String? = null
)

fun mockHospital(): Hospital {
    return Hospital().apply {
        image = R.drawable.ic_hospital_1
        name = "Bệnh viện 108"
        address = "Số 1 Trần Hưng Đạo, Bạch Đằng, Hai Bà Trưng, Hà Nội"
    }
}

fun mockHospitalList(): MutableList<Hospital> {
    val hospitalList = mutableListOf<Hospital>()
    for (i in 0..5) {
        hospitalList.add(mockHospital())
    }
    return hospitalList
}
