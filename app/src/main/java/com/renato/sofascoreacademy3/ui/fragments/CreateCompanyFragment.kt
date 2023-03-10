package com.renato.sofascoreacademy3.ui.fragments

import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.compose.ui.node.getOrAddAdapter
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

    private lateinit var menu:AutoCompleteTextView
    private lateinit var spinnerAdapter:ArrayAdapter<String>

    private lateinit var fields: ArrayList<EditText>

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
        menu = binding.autoCompleteTextView


        viewModel = ViewModelProvider(requireActivity())[CompanyViewModel::class.java]





        return binding.root
    }

    override fun onResume() {
        super.onResume()
        spinnerAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, resources.getStringArray(R.array.continents))
        menu.setAdapter(spinnerAdapter)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        spinnerAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, resources.getStringArray(R.array.continents))
        menu.setAdapter(spinnerAdapter)

        createButton.setOnClickListener {
            if (areEmpty(fields)) {
                Snackbar.make(view, "Please fill out all fields!", Snackbar.LENGTH_SHORT).show()
            } else {
                //val newCompany = Company(nameField.text.toString(), addressField.text.toString(), cityField.text.toString(), countryField.text.toString(), phoneField.text.toString(), emailField.text.toString(), websiteField.text.toString(), industryField.text.toString(), descriptionField.text.toString(), yearField.text.toString(), "", "")
                //viewModel.addCompany(newCompany)
                resetFields(fields)
            }
        }

        for(i in 0..15){
            viewModel.addCompany(Company("", "", "", "", "", "", "", "", "", "", Continent.AFRICA, ""))
        }
    }

    private fun areEmpty(fields: List<EditText>): Boolean {
        for (field in fields) {
            if (field.text.toString() == "") {
                return true
            }
        }
        return false
    }
    private fun resetFields(fields: List<EditText>) {
        for (field in fields) {
            field.text = null
        }
    }
}
