package com.thomnt.medi365.presentation.search.lookupdisease

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.thomnt.medi365.databinding.SearchDoctorFragmentBinding
import com.thomnt.medi365.model.mockDoctorList

class SearchDoctorFragment: Fragment() {

    private lateinit var binding: SearchDoctorFragmentBinding
    private val searchDoctorAdapter = SearchDoctorAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = SearchDoctorFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.rvSearchDoctor.apply {
            adapter = searchDoctorAdapter
            layoutManager = LinearLayoutManager(context)
        }
        searchDoctorAdapter.resetList(mockDoctorList())
    }

}
