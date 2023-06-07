package com.thomnt.medi365.model

import com.thomnt.medi365.R
import com.thomnt.medi365.common.IParcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class News(
    var image: Int? = null,
    var name: String? = null,
    var content: String? = null,
    var time: String? = null,
    var watch: Int? = null
) : IParcelable

fun mockNewsList(): MutableList<News> {
    val newsList = mutableListOf<News>()
    newsList.add(News().apply {
        image = R.drawable.ic_banner
        name = "Chương trình chào hè của Bệnh viện Thu Cúc"
        content = "Từ 1/5-31/5 Bệnh viện thu cúc áp dụng khuyến mại giảm giá 20% toàn các gói khám sức khỏe và gói phẫu thuật"
        time = "30 phút trước"
        watch = 12
    })
    newsList.add(News().apply {
        image = R.drawable.ic_banner_1
        name = "Chương trình mùa hè yêu thương Bệnh viện Nhi Trung Ương"
        content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel maximus orci. Praesent libero erat, hendrerit at sem ac, ultrices pellentesque risus. Praesent in urna ac leo auctor tristique sollicitudin a odio. Nulla facilisi. Curabitur et auctor mauris. Integer at ipsum vitae leo auctor maximus a eget risus"
        time = "1 giờ trước"
        watch = 6
    })
    return newsList
}
