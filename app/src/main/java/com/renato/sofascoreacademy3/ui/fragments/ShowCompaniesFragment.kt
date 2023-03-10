package com.renato.sofascoreacademy3.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.divider.MaterialDivider
import com.renato.sofascoreacademy3.R
import com.renato.sofascoreacademy3.databinding.FragmentShowCompaniesBinding

class ShowCompaniesFragment : Fragment() {

    private lateinit var viewModel: CompanyViewModel
    private lateinit var linearLayout: LinearLayout

    private lateinit var binding: FragmentShowCompaniesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity())[CompanyViewModel::class.java]

        binding = FragmentShowCompaniesBinding.inflate(inflater, container, false)

        linearLayout = binding.linearLayout

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getList().observe(viewLifecycleOwner) { list ->
            linearLayout.removeAllViews()
            list.forEach { item ->
                val textView = TextView(requireContext())
                textView.text = item.toString()
                linearLayout.addView(textView)
                val divider = MaterialDivider(requireContext())
                linearLayout.addView(divider)
            }
        }
    }
}
