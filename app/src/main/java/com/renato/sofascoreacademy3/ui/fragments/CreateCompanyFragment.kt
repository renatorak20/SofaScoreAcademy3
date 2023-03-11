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
import com.renato.sofascoreacademy3.entities.Company
import com.renato.sofascoreacademy3.entities.Industry
import com.renato.sofascoreacademy3.ui.customElements.CustomEditText

class CreateCompanyFragment : Fragment() {

    private lateinit var viewModel: CompanyViewModel

    private lateinit var nameField: CustomEditText
    private lateinit var addressField: CustomEditText
    private lateinit var cityField: CustomEditText
    private lateinit var countryField: CustomEditText
    private lateinit var founderField: CustomEditText
    private lateinit var emailField: CustomEditText
    private lateinit var websiteField: CustomEditText
    private lateinit var descriptionField: CustomEditText
    private lateinit var sloganField: CustomEditText
    private lateinit var createButton: Button

    private lateinit var spinner: Spinner
    private lateinit var spinnerAdapter: ArrayAdapter<Industry>


    private lateinit var constraintLayout: ConstraintLayout

    private lateinit var binding: FragmentCreateCompanyBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentCreateCompanyBinding.inflate(inflater, container, false)

        nameField = binding.nameField
        addressField = binding.addressField
        cityField = binding.cityField
        countryField = binding.countryField
        founderField = binding.founderField
        emailField = binding.emailField
        websiteField = binding.websiteField
        descriptionField = binding.descriptionField
        sloganField = binding.sloganField
        createButton = binding.button
        spinner = binding.spinner

        constraintLayout = binding.constraintLayout

        viewModel = ViewModelProvider(requireActivity())[CompanyViewModel::class.java]

        spinnerAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, Industry.values())
        spinner.adapter = spinnerAdapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        createButton.setOnClickListener {
            addCompany()
        }
    }

    private fun addCompany(){
        if (constraintLayout.areAllFieldsValid()) {
            val company = Company(
                nameField.getText(),
                addressField.getText(),
                cityField.getText(),
                countryField.getText(),
                founderField.getText(),
                emailField.getText(),
                websiteField.getText(),
                descriptionField.getText(),
                sloganField.getText(),
                spinner.selectedItem as Industry,
                getRadioSelectedValue())
            viewModel.addCompany(company)
            Toast.makeText(context, "Hurray, You successfully added new company!", Toast.LENGTH_SHORT).show()
            constraintLayout.resetFields()
        }
    }

    private fun getRadioSelectedValue() : String{
        val type:String =
            when(binding.radioGroup.radioGroup.checkedRadioButtonId){
                R.id.company_public -> "Public"
                R.id.company_private -> "Private"
                else -> "None"
            }
        return type
    }

    private fun ConstraintLayout.areAllFieldsValid(): Boolean {
        this.children.filterIsInstance<CustomEditText>().forEach {
            if (!it.isValid()) {
                Toast.makeText(context, "Please enter more than 3 characters in all fields!", Toast.LENGTH_SHORT).show()
                return false
            }
        }
        return true
    }

    private fun ConstraintLayout.resetFields() {
        this.children.filterIsInstance<CustomEditText>().forEach {
            it.clear()
        }
    }
}

