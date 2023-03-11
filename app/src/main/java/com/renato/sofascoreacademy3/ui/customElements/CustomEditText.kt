package com.renato.sofascoreacademy3.ui.customElements

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.renato.sofascoreacademy3.R
import com.renato.sofascoreacademy3.databinding.CustomEditTextBinding

class CustomEditText(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {

    private val binding: CustomEditTextBinding

    init{
        inflate(context, R.layout.custom_edit_text, null)
        binding = CustomEditTextBinding.inflate(LayoutInflater.from(context), null, false)
        addView(binding.root)

        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.CustomEditText, 0, 0).apply {
            try {
                val hint = getString(R.styleable.CustomEditText_hint)
                binding.field.hint = hint
            } finally {
                recycle()
            }
        }
    }

    fun getText() : String{
        return binding.field.text.toString()
    }
    private fun getLenght():Int{
        return getText().length
    }
    fun clear(){
        binding.field.text.clear()
    }

    fun isValid() : Boolean{
        if(getLenght() < 4){
            return false
        }
        return true
    }
}