package com.thomnt.medi365.model

import com.thomnt.medi365.R

data class Clinic(
    var image: Int? = null,
    var name: String? = null,
    var address: String? = null
)

fun mockClinic(): Clinic {
    return Clinic().apply {
        image = R.drawable.ic_clinic_1
        name = "Phòng khám sản phụ khoa 43 Nguyễn Khang"
        address = "43 Nguyễn Khang, Trung Hòa, Cầu giấy, Hà Nội"
    }
}

fun mockClinicList(): MutableList<Clinic> {
    val clinicList = mutableListOf<Clinic>()
    for (i in 0..5) {
        clinicList.add(mockClinic())
    }
    return clinicList
}
