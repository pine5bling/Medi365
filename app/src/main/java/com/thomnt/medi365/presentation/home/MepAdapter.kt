package com.thomnt.medi365.presentation.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thomnt.medi365.common.getAppDrawable
import com.thomnt.medi365.common.loadImage
import com.thomnt.medi365.databinding.OutstandingMepItemBinding
import com.thomnt.medi365.model.MEP

class MepAdapter : RecyclerView.Adapter<MepAdapter.MepVH>() {

    private val mepList = mutableListOf<MEP>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MepVH {
        val binding = OutstandingMepItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MepVH(binding)
    }

    override fun onBindViewHolder(holder: MepVH, position: Int) {
        holder.onBindData(mepList[position])
    }

    override fun getItemCount() = mepList.size

    @SuppressLint("NotifyDataSetChanged")
    fun resetData(mepList: MutableList<MEP>) {
        this.mepList.clear()
        this.mepList.addAll(mepList)
        notifyDataSetChanged()
    }

    inner class MepVH(private val binding: OutstandingMepItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBindData(mep: MEP) {
            binding.ivMep.loadImage(getAppDrawable(mep.image!!))
            binding.tvMepName.text = mep.name
            binding.tvMepClinic.text = mep.clinicName
            binding.tvMepWatchNumber.text = mep.watchNumber.toString()
            binding.tvMepCartNumber.text = mep.cartNumber.toString()
            binding.tvMepGender.text = mep.gender
            binding.tvMepCurrentPrice.text = mep.currentPrice.toString()
            binding.tvMepPreviousPrice.text = mep.previousPrice.toString()
        }
    }
}
