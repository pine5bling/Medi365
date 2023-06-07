package com.thomnt.medi365.model

import com.thomnt.medi365.R

data class Doctor(
    var id: Int? = null,
    var avatar: Int? = null,
    var name: String? = null,
    var position: String? = null, // chức vụ
    var department: String? = null, // khoa
    var adress: String? = null,
    var currentPrice: String? = null,
    var previousPrice: String? = null,
    var time: String? = null
)

fun mockDoctor(): Doctor {
    return Doctor().apply {
        avatar = R.drawable.ic_doctor
        name = "TS.Nguyễn Văn A"
        position = "Trưởng khoa tiêu hóa bệnh viện 108"
        department = "Tiêu hóa - Gan mật"
        adress = "265 Giải Phóng, Hai Bà Trưng, Hà Nội"
        currentPrice = "250.000đ"
    }
}

fun mockDoctorList(): MutableList<Doctor> {
    val doctorList = mutableListOf<Doctor>()
    doctorList.add(Doctor().apply {
        avatar = R.drawable.ic_doctor_male
        name = "TS.Nguyễn Văn A"
        position = "Trưởng khoa tiêu hóa bệnh viện 108"
        currentPrice = "250.000đ"
        previousPrice = "350.000đ"
        adress = "265 Giải Phóng, Hai Bà Trưng, Hà Nội"
    })
    doctorList.add(Doctor().apply {
        avatar = R.drawable.ic_doctor_female
        name = "PGS.TS.Trần Thị B"
        position = "Trưởng khoa tiêu hóa bệnh viện 108"
        currentPrice = "250.000đ"
        previousPrice = "350.000đ"
        adress = "265 Giải Phóng, Hai Bà Trưng, Hà Nội"
    })
    doctorList.add(Doctor().apply {
        avatar = R.drawable.ic_doctor_male
        name = "GS.TS.Lê Văn C"
        position = "Trưởng khoa tiêu hóa bệnh viện 108"
        currentPrice = "250.000đ"
        previousPrice = "350.000đ"
        adress = "265 Giải Phóng, Hai Bà Trưng, Hà Nội"
    })
    return doctorList
}
