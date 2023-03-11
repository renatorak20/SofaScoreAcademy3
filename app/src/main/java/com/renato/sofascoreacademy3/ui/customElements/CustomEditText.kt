package com.renato.sofascoreacademy3.ui.customElements

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.EditText
import com.renato.sofascoreacademy3.R
import com.renato.sofascoreacademy3.databinding.CustomEditTextBinding


class CustomEditText(context: Context, attrs: AttributeSet?) :
    androidx.appcompat.widget.AppCompatEditText(context, attrs) {

    private var binding: CustomEditTextBinding

    init {
        binding = CustomEditTextBinding.inflate(LayoutInflater.from(context), null, false)
        inflate(context, R.layout.custom_edit_text, null)
    }

    fun isValid(){
        if(this.text?.length!! > 10){
            println("STRING IS VALID")
        }
    }
}