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

class ShowCompaniesFragment : Fragment() {

    private lateinit var viewModel: CompanyViewModel
    private lateinit var companiesInflater: LayoutInflater

    private lateinit var linearLayout: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity())[CompanyViewModel::class.java]
        companiesInflater = LayoutInflater.from(context)

        val view = inflater.inflate(R.layout.fragment_show_companies, container, false)

        linearLayout = view.findViewById(R.id.linear_layout)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getList().observe(viewLifecycleOwner) { list ->
            linearLayout.removeAllViews()
            list.forEach { item ->
                val string = item.name + ", " + item.address + ", " + item.city + ", " + item.country + ", " + item.phone + ", " + item.email + ", " + item.website + ", " + item.industry + ", " + item.description + ", " + item.foundedYear
                val textView = TextView(requireContext())
                textView.text = string
                linearLayout.addView(textView)
                val divider = MaterialDivider(requireContext())
                linearLayout.addView(divider)
            }
        }
    }
}
