package com.thomnt.medi365.model

import com.thomnt.medi365.R

data class Department(
    var imageDept: Int? = null,
    var nameDept: String? = null
)

fun mockDeptList(): MutableList<Department> {
    val deptList = mutableListOf<Department>()
    deptList.add(Department().apply {
        imageDept = R.drawable.ic_orthopedics
        nameDept = "Chấn thương chỉnh hình"
    })
    deptList.add(Department().apply {
        imageDept = R.drawable.ic_musculoskeletal
        nameDept = "Cơ xương khớp"
    })
    deptList.add(Department().apply {
        imageDept = R.drawable.ic_endocrinology
        nameDept = "Nội tiết & Đái tháo đường"
    })
    deptList.add(Department().apply {
        imageDept = R.drawable.ic_maternity
        nameDept = "Sản phụ khoa"
    })
    deptList.add(Department().apply {
        imageDept = R.drawable.ic_andrology
        nameDept = "Nam khoa"
    })
    deptList.add(Department().apply {
        imageDept = R.drawable.ic_cosmetic_surgery
        nameDept = "Phẫu thuật thẩm mĩ"
    })
    deptList.add(Department().apply {
        imageDept = R.drawable.ic_general_surgery
        nameDept = "Ngoại tổng hợp"
    })
    deptList.add(Department().apply {
        imageDept = R.drawable.ic_gastroenterology
        nameDept = "Nội soi tiêu hóa"
    })
    return deptList
}
