package com.thomnt.medi365.presentation.search.lookupdisease

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.thomnt.medi365.R
import com.thomnt.medi365.databinding.DepartmentFragmentBinding
import com.thomnt.medi365.model.mockDeptList

class DepartmentFragment : Fragment() {

    private lateinit var binding: DepartmentFragmentBinding
    private val deptAdapter by lazy { DeptAdapter() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DepartmentFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.rvDept.apply {
            adapter = deptAdapter
            layoutManager = LinearLayoutManager(context)
        }
        deptAdapter.resetList(mockDeptList())

        deptAdapter.listener = object : DeptAdapter.IDeptListener {
            override fun onDeptClick() {
                val transaction = parentFragmentManager.beginTransaction()
                transaction.replace(R.id.constDeptContainer, DepartmentDetailFragment())
                transaction.addToBackStack("DepartmentDetailFragment")
                transaction.commit()
            }
        }
    }
}
