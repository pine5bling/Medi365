package com.thomnt.medi365.presentation.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.thomnt.medi365.databinding.OutstandingClinicBoardItemBinding
import com.thomnt.medi365.databinding.OutstandingDoctorBoardItemBinding
import com.thomnt.medi365.databinding.OutstandingHospitalBoardItemBinding
import com.thomnt.medi365.databinding.OutstandingMepBoardItemBinding
import com.thomnt.medi365.model.Clinic
import com.thomnt.medi365.model.Doctor
import com.thomnt.medi365.model.Hospital
import com.thomnt.medi365.model.MEP

class HomeAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val INVALID_RESOURCE = -1

        //        const val USER_INFO_TYPE = 0
//        const val MISSION_TYPE = 1
        const val DOCTOR_TYPE = 2
        const val CLINIC_TYPE = 3
        const val HOSPITAL_TYPE = 4
        const val MEP_TYPE = 5
    }

    private var homeList = mutableListOf<Any>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
//            USER_INFO_TYPE -> {
//                val binding = UserInfoBoardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//                UserInfoVH(binding)
//            }
//            MISSION_TYPE -> {
//                val binding = HomeMissionViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//                MissionVH(binding)
//            }
            DOCTOR_TYPE -> {
                val binding = OutstandingDoctorBoardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                DoctorBoardVH(binding)
            }
            CLINIC_TYPE -> {
                val binding = OutstandingClinicBoardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ClinicBoardVH(binding)
            }
            HOSPITAL_TYPE -> {
                val binding = OutstandingHospitalBoardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                HospitalBoardVH(binding)
            }
            else -> {
                val binding = OutstandingMepBoardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                MepBoardVH(binding)
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun resetData(newData: MutableList<Any>) {
        this.homeList.clear()
        this.homeList.addAll(newData)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.apply {
            when (holder) {
//                is UserInfoVH -> holder.onBind(homeList[position] as UserInfo)
                is DoctorBoardVH -> holder.onBind(homeList[position] as List<Doctor>)
                is ClinicBoardVH -> holder.onBind(homeList[position] as List<Clinic>)
                is HospitalBoardVH -> holder.onBind(homeList[position] as List<Hospital>)
                is MepBoardVH -> holder.onBind(homeList[position] as List<MEP>)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
//        return when (homeList.getOrNull(position)) {
//            is UserInfo -> USER_INFO_TYPE
//            is
//            is ClinicDisplay -> CLINIC_TYPE
//
//            else -> -1
//        }

        return when (position) {
            0 -> DOCTOR_TYPE
            1 -> CLINIC_TYPE
            2 -> HOSPITAL_TYPE
            3 -> MEP_TYPE
            else -> -1
        }
    }

    override fun getItemCount() = homeList.size

//    inner class UserInfoVH(private val binding: UserInfoBoardItemBinding) : RecyclerView.ViewHolder(binding.root) {
//        fun onBind(userInfo: UserInfo) {
//            binding.ivUserAvatar.loadImage(getAppDrawable(userInfo.avatar!!))
//            binding.tvUserName.text = userInfo.fullName
//            binding.tvUserPhone.text = userInfo.phoneNumber
//        }
//    }
//
//    inner class MissionVH(private val binding: HomeMissionViewItemBinding) : RecyclerView.ViewHolder(binding.root) {}

    inner class DoctorBoardVH(private val binding: OutstandingDoctorBoardItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private val doctorAdapter by lazy { DoctorAdapter() }

        init {
            binding.rvDoctorBoard.adapter = doctorAdapter
            binding.rvDoctorBoard.layoutManager = LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
        }

        fun onBind(data: List<Doctor>) {
            doctorAdapter.resetData(data as MutableList<Doctor>)
        }
    }

    data class DoctorDisplay(
        var list: List<Doctor>
    )

    inner class ClinicBoardVH(private val binding: OutstandingClinicBoardItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private val clinicAdapter by lazy { ClinicAdapter() }

        init {
            binding.rvClinicBoard.adapter = clinicAdapter
            binding.rvClinicBoard.layoutManager = LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
        }

        fun onBind(data: List<Clinic>) {
            clinicAdapter.resetData(data as MutableList<Clinic>)
        }

    }

    data class ClinicDisplay(
        var list: List<Clinic>
    )

    inner class HospitalBoardVH(private val binding: OutstandingHospitalBoardItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private val hospitalAdapter by lazy { HospitalAdapter() }

        init {
            binding.rvHospitalBoard.adapter = hospitalAdapter
            binding.rvHospitalBoard.layoutManager = LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
        }

        fun onBind(data: List<Hospital>) {
            hospitalAdapter.resetData(data as MutableList<Hospital>)
        }
    }

    data class HospitalDisplay(
        var list: List<Hospital>
    )

    inner class MepBoardVH(private val binding: OutstandingMepBoardItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private val mepAdapter by lazy { MepAdapter() }

        init {
            binding.rvMepBoard.adapter = mepAdapter
            binding.rvMepBoard.layoutManager = LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
        }

        fun onBind(data: List<MEP>) {
            mepAdapter.resetData(data as MutableList<MEP>)
        }
    }

    data class MepDisplay(
        var list: List<MEP>
    )


}
