package com.thomnt.medi365.presentation.search

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.thomnt.medi365.R
import com.thomnt.medi365.databinding.SearchFragmentBinding
import com.thomnt.medi365.presentation.search.lookupdisease.DepartmentFragment
import com.thomnt.medi365.presentation.search.lookupdrug.LookupDoctorFragment

class SearchFragment : Fragment() {

    private lateinit var binding: SearchFragmentBinding

    private val baseActivity by lazy {
        requireActivity() as Activity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = SearchFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.constSearchDisease.setOnClickListener {
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.constSearchRoot, DepartmentFragment())
            transaction.addToBackStack("DepartmentFragment") // (Tùy chọn) Cho phép nhấn nút Back để quay lại Fragment trước đó
            transaction.commit()
        }

        binding.constSearchMedicine.setOnClickListener {
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.constSearchRoot, LookupDoctorFragment())
            transaction.addToBackStack("LookupDoctorFragment")
            transaction.commit()
        }
    }
}
