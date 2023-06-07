package com.thomnt.medi365.presentation.search.lookupdisease

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thomnt.medi365.common.getAppDrawable
import com.thomnt.medi365.common.loadImage
import com.thomnt.medi365.databinding.DepartmentItemLayoutBinding
import com.thomnt.medi365.model.Department

class DeptAdapter : RecyclerView.Adapter<DeptAdapter.DeptVH>() {

    private val deptList = mutableListOf<Department>()
    var listener: IDeptListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeptVH {
        val binding = DepartmentItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DeptVH(binding)
    }

    override fun onBindViewHolder(holder: DeptVH, position: Int) {
        holder.bindData(deptList[position])
    }

    override fun getItemCount() = deptList.size

    @SuppressLint("NotifyDataSetChanged")
    fun resetList(deptList: MutableList<Department>) {
        this.deptList.clear()
        this.deptList.addAll(deptList)
        notifyDataSetChanged()
    }

    inner class DeptVH(private val binding: DepartmentItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.constDept.setOnClickListener {
                listener?.onDeptClick()
            }
        }

        fun bindData(department: Department) {
            binding.ivDept.loadImage(getAppDrawable(department.imageDept!!))
            binding.tvDept.text = department.nameDept
        }
    }

    interface IDeptListener {
        fun onDeptClick()
    }

}
