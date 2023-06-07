package com.thomnt.medi365.presentation.search.lookupdisease

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thomnt.medi365.common.getAppDrawable
import com.thomnt.medi365.common.loadImage
import com.thomnt.medi365.databinding.SearchDoctorItemBinding
import com.thomnt.medi365.model.Doctor
import com.thomnt.medi365.presentation.home.DoctorAdapter

class SearchDoctorAdapter : RecyclerView.Adapter<SearchDoctorAdapter.SearchDoctorVH>() {

    private val doctortList = mutableListOf<Doctor>()
    var listener: DoctorAdapter.ISearchDoctorListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchDoctorVH {
        val binding = SearchDoctorItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchDoctorVH(binding)
    }

    override fun onBindViewHolder(holder: SearchDoctorVH, position: Int) {
        holder.bindData(doctortList[position])
    }

    override fun getItemCount() = doctortList.size

    @SuppressLint("NotifyDataSetChanged")
    fun resetList(doctortList: MutableList<Doctor>) {
        this.doctortList.clear()
        this.doctortList.addAll(doctortList)
        notifyDataSetChanged()
    }

    inner class SearchDoctorVH(private val binding: SearchDoctorItemBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.mvDoctorBooking.setOnClickListener {
                listener?.onBookingClick()
            }
            binding.mvDoctorAdvisa.setOnClickListener {
                listener?.onAdvisaClick()
            }
        }

        fun bindData(doctor: Doctor) {
            binding.ivDoctorAvatar.loadImage(getAppDrawable(doctor.avatar!!))
            binding.tvDoctorName.text = doctor.name
            binding.tvDoctorPosition.text = doctor.position
            binding.tvDoctorTime.text = doctor.time
            binding.tvDoctorAdress.text = doctor.adress
            binding.tvMepCurrentPrice.text = doctor.currentPrice
            binding.tvMepPreviousPrice.text = doctor.previousPrice
        }
    }

    interface ISearchDoctorListener {
        fun onBookingClick()
        fun onAdvisaClick()
    }
}

