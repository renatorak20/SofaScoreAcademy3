package com.renato.sofascoreacademy3.ui.fragments

import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import com.renato.sofascoreacademy3.R
import com.renato.sofascoreacademy3.databinding.FragmentCreateCompanyBinding
import com.renato.sofascoreacademy3.entities.Company
import com.renato.sofascoreacademy3.entities.Continent

class CreateCompanyFragment : Fragment() {

    private lateinit var viewModel: CompanyViewModel

    private lateinit var nameField: EditText
    private lateinit var addressField: EditText
    private lateinit var cityField: EditText
    private lateinit var countryField: EditText
    private lateinit var phoneField: EditText
    private lateinit var emailField: EditText
    private lateinit var websiteField: EditText
    private lateinit var industryField: EditText
    private lateinit var descriptionField: EditText
    private lateinit var yearField: EditText
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
        yearField = binding.yearField
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
            if(constraintLayout.areAllFieldsValid()){
                val company = Company(nameField.text.toString(), addressField.text.toString(), cityField.text.toString(), countryField.text.toString(), phoneField.text.toString(), emailField.text.toString(), websiteField.text.toString(), industryField.text.toString(), descriptionField.text.toString(), yearField.text.toString(), spinner.selectedItem.toString(), binding.root.findViewById<RadioButton>(binding.radioGroup.checkedRadioButtonId).text.toString())
                viewModel.addCompany(company)
                constraintLayout.resetFields()
            }
        }


    }

    private fun ConstraintLayout.areAllFieldsValid(): Boolean{
        this.children.filterIsInstance<EditText>().forEach {
            if(it.isEmpty()){
                Snackbar.make(this, "Please fill out all fields!", Snackbar.LENGTH_SHORT).show()
                return false
            }
        }
        return true
    }
    private fun ConstraintLayout.resetFields() {
        this.children.filterIsInstance<EditText>().forEach {
            it.text.clear()
        }
    }
    private fun EditText.isEmpty() : Boolean{
        if(this.text.toString() == ""){
            return true
        }
        return false
    }
}
