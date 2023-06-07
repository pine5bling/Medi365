package com.thomnt.medi365.presentation.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thomnt.medi365.common.getAppDrawable
import com.thomnt.medi365.common.loadImage
import com.thomnt.medi365.databinding.OutstandingClinicItemBinding
import com.thomnt.medi365.model.Clinic

class ClinicAdapter : RecyclerView.Adapter<ClinicAdapter.ClinicVH>() {

    private val clinicList = mutableListOf<Clinic>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClinicVH {
        val binding = OutstandingClinicItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ClinicVH(binding)
    }

    override fun onBindViewHolder(holder: ClinicVH, position: Int) {
        holder.onBindData(clinicList[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun resetData(clinicList: List<Clinic>){
        this.clinicList.clear()
        this.clinicList.addAll(clinicList)
        notifyDataSetChanged()
    }

    override fun getItemCount() = clinicList.size

    inner class ClinicVH(private val binding: OutstandingClinicItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBindData(clinic: Clinic) {
            binding.ivClinic.loadImage(getAppDrawable(clinic.image!!))
            binding.tvClinicName.text = clinic.name
            binding.tvClinicAddress.text = clinic.address
        }
    }
}
