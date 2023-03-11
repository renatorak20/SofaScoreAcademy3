package com.renato.sofascoreacademy3.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.divider.MaterialDivider
import com.renato.sofascoreacademy3.R
import com.renato.sofascoreacademy3.databinding.FragmentShowCompaniesBinding
import com.renato.sofascoreacademy3.entities.Company

class ShowCompaniesFragment : Fragment() {

    private lateinit var viewModel: CompanyViewModel
    private lateinit var listView: ListView
    private lateinit var binding: FragmentShowCompaniesBinding
    private lateinit var adapter:ArrayAdapter<Company>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity())[CompanyViewModel::class.java]

        binding = FragmentShowCompaniesBinding.inflate(inflater, container, false)

        listView = binding.listView

        adapter = ArrayAdapter(requireContext(), R.layout.company_object, viewModel.companies.value ?: mutableListOf())
        listView.adapter = adapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getList().observe(viewLifecycleOwner) {
            adapter = ArrayAdapter(requireContext(), R.layout.company_object, viewModel.companies.value ?: mutableListOf())
            listView.adapter = adapter
            adapter.notifyDataSetChanged()
        }
    }
}
