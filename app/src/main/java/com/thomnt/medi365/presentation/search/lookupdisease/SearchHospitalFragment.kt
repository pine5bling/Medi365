package com.thomnt.medi365.presentation.search.lookupdisease

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.thomnt.medi365.databinding.SearchClinicFragmentBinding
import com.thomnt.medi365.databinding.SearchHospitalFragmentBinding
import com.thomnt.medi365.model.mockClinicList
import com.thomnt.medi365.model.mockHospitalList

class SearchHospitalFragment: Fragment() {

    private lateinit var binding: SearchHospitalFragmentBinding
    private val searchHospitalAdapter = SearchHospitalAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = SearchHospitalFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.rvSearchHospital.apply {
            adapter = searchHospitalAdapter
            layoutManager = LinearLayoutManager(context)
        }
        searchHospitalAdapter.resetData(mockHospitalList())
    }

}
