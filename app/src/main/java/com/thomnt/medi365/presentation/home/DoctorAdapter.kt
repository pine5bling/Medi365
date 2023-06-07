package com.thomnt.medi365.presentation.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thomnt.medi365.common.getAppDrawable
import com.thomnt.medi365.common.loadImage
import com.thomnt.medi365.databinding.OutstandingDoctorItemBinding
import com.thomnt.medi365.model.Doctor

class DoctorAdapter : RecyclerView.Adapter<DoctorAdapter.DoctorVH>() {

    private val doctorList = mutableListOf<Doctor>()
    var listener: ISearchDoctorListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorVH {
        val binding = OutstandingDoctorItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DoctorVH(binding)
    }

    override fun onBindViewHolder(holder: DoctorVH, position: Int) {
        holder.onBindData(doctorList[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun resetData(doctorList: MutableList<Doctor>) {
        this.doctorList.clear()
        this.doctorList.addAll(doctorList)
        notifyDataSetChanged()
    }

    override fun getItemCount() = doctorList.size

    inner class DoctorVH(private val binding: OutstandingDoctorItemBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.mvDoctorBooking.setOnClickListener {
                listener?.onBookingClick()
            }
            binding.mvDoctorAdvisa.setOnClickListener {
                listener?.onAdvisaClick()
            }
        }

        fun onBindData(doctor: Doctor) {
            binding.ivDoctorAvatar.loadImage(getAppDrawable(doctor.avatar!!))
            binding.tvDoctorName.text = doctor.name
            binding.tvDoctorPosition.text = doctor.position
            binding.tvDoctorDepartment.text = doctor.department
            binding.tvDoctorAdress.text = doctor.adress
            binding.tvDoctorPrice.text = doctor.currentPrice
        }
    }

    interface ISearchDoctorListener {
        fun onBookingClick()
        fun onAdvisaClick()
    }
}
