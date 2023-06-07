package com.thomnt.medi365.presentation.search.lookupdrug

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.thomnt.medi365.databinding.LookupDoctorFragmentBinding

class LookupDoctorFragment : Fragment() {

    private lateinit var binding: LookupDoctorFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = LookupDoctorFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    }

}
