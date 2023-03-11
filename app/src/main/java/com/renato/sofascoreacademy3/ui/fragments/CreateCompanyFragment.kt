package com.renato.sofascoreacademy3.ui.fragments

import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.renato.sofascoreacademy3.R
import com.renato.sofascoreacademy3.databinding.FragmentCreateCompanyBinding
import com.renato.sofascoreacademy3.entities.Continent
import com.renato.sofascoreacademy3.ui.customElements.CustomEditText

class CreateCompanyFragment : Fragment() {

    private lateinit var viewModel: CompanyViewModel

    private lateinit var nameField: CustomEditText
    private lateinit var addressField: CustomEditText
    private lateinit var cityField: CustomEditText
    private lateinit var countryField: CustomEditText
    private lateinit var phoneField: CustomEditText
    private lateinit var emailField: CustomEditText
    private lateinit var websiteField: CustomEditText
    private lateinit var industryField: CustomEditText
    private lateinit var descriptionField: CustomEditText
    private lateinit var yearField: CustomEditText
    private lateinit var createButton: Button

    private lateinit var spinner:Spinner
    private lateinit var spinnerAdapter:ArrayAdapter<Continent>

    private lateinit var radioGroup: ViewGroup

    private lateinit var constraintLayout: ConstraintLayout

    private lateinit var binding: FragmentCreateCompanyBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCreateCompanyBinding.inflate(inflater, container, false)

        nameField = binding.nameField
        addressField = binding.addressField
        cityField = binding.cityField
        countryField = binding.countryField
        phoneField = binding.phoneField
        emailField = binding.emailField
        websiteField = binding.websiteField
        industryField = binding.industryField
        descriptionField = binding.descriptionField
        yearField = binding.foundedYearField
        createButton = binding.button
        spinner = binding.spinner

        constraintLayout = binding.constraintLayout

        radioGroup = binding.radioGroup

        viewModel = ViewModelProvider(requireActivity())[CompanyViewModel::class.java]

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        spinnerAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, Continent.values())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        spinnerAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, Continent.values())
        spinner.adapter = spinnerAdapter

        createButton.setOnClickListener {
           nameField.isValid()


            /*if(constraintLayout.areAllFieldsValid()){
                //val company = Company(nameField.text.toString(), addressField.text.toString(), cityField.text.toString(), countryField.text.toString(), phoneField.text.toString(), emailField.text.toString(), websiteField.text.toString(), industryField.text.toString(), descriptionField.text.toString(), yearField.text.toString(), spinner.selectedItem.toString(), binding.root.findViewById<RadioButton>(binding.radioGroup.checkedRadioButtonId).text.toString())
                //viewModel.addCompany(company)
                //constraintLayout.resetFields()
            }*/
        }

    }
/*
    private fun ConstraintLayout.areAllFieldsValid(): Boolean{
        this.children.filterIsInstance<CompanyInput>().forEach {
            if(it.isValid()){
                return false
            }
        }
        return true
    }
    private fun CompanyInputBinding.resetFields() {
this.children.filterIsInstance<CompanyInputBinding>().forEach {
    //it.text?.clear()
}*/
}

