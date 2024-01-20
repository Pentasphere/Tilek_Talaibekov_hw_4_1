package com.geeks.tilek_talaibekov_hw_4_1.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.geeks.tilek_talaibekov_hw_4_1.R
import com.geeks.tilek_talaibekov_hw_4_1.databinding.FragmentHomeBinding
import com.geeks.tilek_talaibekov_hw_4_1.model.Task
import com.geeks.tilek_talaibekov_hw_4_1.ui.home.adapter.TaskAdapter
import com.geeks.tilek_talaibekov_hw_4_1.ui.task.TaskFragment.Companion.TASK_KEY
import com.geeks.tilek_talaibekov_hw_4_1.ui.task.TaskFragment.Companion.TASK_RESULT_KEY
import kotlin.math.log

@Suppress("CAST_NEVER_SUCCEEDS", "DEPRECATION")
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val adapter = TaskAdapter()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvTasks.adapter = adapter
        setFragmentResultListener(TASK_RESULT_KEY){ _, bundle ->
            val data = bundle.getSerializable(TASK_KEY) as Task
            adapter.addTask(data)
        }
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.taskFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}