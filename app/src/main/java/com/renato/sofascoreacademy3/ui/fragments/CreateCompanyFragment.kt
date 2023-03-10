package com.renato.sofascoreacademy3.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.renato.sofascoreacademy3.R
import com.renato.sofascoreacademy3.entities.Company

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

    private lateinit var fields: ArrayList<EditText>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_create_company, container, false)

        nameField = view.findViewById(R.id.name_field)
        addressField = view.findViewById(R.id.address_field)
        cityField = view.findViewById(R.id.city_field)
        countryField = view.findViewById(R.id.country_field)
        phoneField = view.findViewById(R.id.phone_field)
        emailField = view.findViewById(R.id.email_field)
        websiteField = view.findViewById(R.id.website_field)
        industryField = view.findViewById(R.id.industry_field)
        descriptionField = view.findViewById(R.id.description_field)
        yearField = view.findViewById(R.id.year_field)
        createButton = view.findViewById(R.id.button)

        viewModel = ViewModelProvider(requireActivity())[CompanyViewModel::class.java]

        fields = arrayListOf(
            nameField, addressField, phoneField, emailField, websiteField,
            cityField, countryField, descriptionField, yearField,
            industryField
        )

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        createButton.setOnClickListener {
            if (areEmpty(fields)) {
                Snackbar.make(view, "Please fill out all fields!", Snackbar.LENGTH_SHORT).show()
            } else {
                val newCompany = Company(nameField.text.toString(), addressField.text.toString(), cityField.text.toString(), countryField.text.toString(), phoneField.text.toString(), emailField.text.toString(), websiteField.text.toString(), industryField.text.toString(), descriptionField.text.toString(), yearField.text.toString())
                viewModel.addCompany(newCompany)
                resetFields(fields)
            }
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
