package com.thomnt.medi365.presentation.search.lookupdisease

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.thomnt.medi365.databinding.DepartmentDetailFragmentBinding
import com.thomnt.medi365.widget.ViewPagerAdapter

class DepartmentDetailFragment : Fragment() {

    private lateinit var binding: DepartmentDetailFragmentBinding
    private var viewPagerAdapter: ViewPagerAdapter = ViewPagerAdapter(parentFragmentManager)
    private var searchDoctor = SearchDoctorFragment()
    private var searchClinic = SearchClinicFragment()
    private var searchHospital = SearchHospitalFragment()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DepartmentDetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        setupTabView()
//        setupViewPager()
    }

//    private fun setupTabView() {
//        binding.tabVDeptDetail.setOnTabClick {
//            binding.vpDeptDetail.currentItem = getPosition(it)
//        }
//    }
//
//    private fun setupViewPager() {
//        viewPagerAdapter.addTab(Tab().apply {
//            fragment = searchDoctor
//        })
//        viewPagerAdapter.addTab(Tab().apply {
//            fragment = searchClinic
//        })
//        viewPagerAdapter.addTab(Tab().apply {
//            fragment = searchHospital
//        })
//
//        binding.vpDeptDetail.apply {
//            adapter = viewPagerAdapter
//            addOnPageSelected {
//                binding.tabVDeptDetail.setTabSelected(getTab(it))
//            }
//        }
//    }
//
//    private fun getPosition(tab: TabView.TAB): Int {
//        return when (tab) {
//            TabView.TAB.CENTER -> 1
//            TabView.TAB.CENTER_2 -> 2
//            TabView.TAB.RIGHT -> 3
//            else -> 0
//        }
//    }
//
//    private fun getTab(position: Int): TabView.TAB {
//        return when (position) {
//            1 -> TabView.TAB.CENTER
//            2 -> TabView.TAB.CENTER_2
//            3 -> TabView.TAB.RIGHT
//            else -> TabView.TAB.LEFT
//        }
//    }

}
