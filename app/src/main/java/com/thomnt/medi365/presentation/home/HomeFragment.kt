package com.thomnt.medi365.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.thomnt.medi365.databinding.HomeFragmentBinding
import com.thomnt.medi365.model.mockClinicList
import com.thomnt.medi365.model.mockDoctorList
import com.thomnt.medi365.model.mockHospitalList
import com.thomnt.medi365.model.mockMEPList

class HomeFragment : Fragment() {

    private lateinit var binding: HomeFragmentBinding
    private val homeAdapter by lazy { HomeAdapter() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvHome.apply {
            adapter = homeAdapter
            layoutManager = LinearLayoutManager(context)
        }

        homeAdapter.resetData(data())
    }

    private fun data(): MutableList<Any> {
        val homeList = mutableListOf<Any>()
        homeList.add(mockDoctorList())
        homeList.add(mockClinicList())
        homeList.add(mockHospitalList())
        homeList.add(mockMEPList())
        return homeList
    }

}
