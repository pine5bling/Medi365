package com.thomnt.medi365.presentation.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thomnt.medi365.common.getAppDrawable
import com.thomnt.medi365.common.loadImage
import com.thomnt.medi365.databinding.OutstandingClinicItemBinding
import com.thomnt.medi365.model.Hospital

class HospitalAdapter : RecyclerView.Adapter<HospitalAdapter.HospitalVH>() {

    private val hospitalList = mutableListOf<Hospital>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalVH {
        val binding = OutstandingClinicItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HospitalVH(binding)
    }

    override fun onBindViewHolder(holder: HospitalVH, position: Int) {
        holder.onBindData(hospitalList[position])
    }

    override fun getItemCount() = hospitalList.size

    @SuppressLint("NotifyDataSetChanged")
    fun resetData(hospitalList: MutableList<Hospital>) {
        this.hospitalList.clear()
        this.hospitalList.addAll(hospitalList)
        notifyDataSetChanged()
    }

    inner class HospitalVH(private val binding: OutstandingClinicItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBindData(hospital: Hospital) {
            binding.ivClinic.loadImage(getAppDrawable(hospital.image!!))
            binding.tvClinicName.text = hospital.name
            binding.tvClinicAddress.text = hospital.address
        }
    }
}
