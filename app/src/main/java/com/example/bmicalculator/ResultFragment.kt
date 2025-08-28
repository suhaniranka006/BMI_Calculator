package com.example.bmicalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class ResultFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_result, container, false)

        val tvResult = view.findViewById<TextView>(R.id.tvResult)

        val bmi = arguments?.getFloat("bmi_value")

        bmi?.let {
            val category = when {
                it < 18.5 -> "UnderWeight"
                it in 18.5..24.9 -> "Normal"
                it in 25.0..29.9 -> "OverWeight"
                else -> "Obese"
            }
            tvResult.text = "Your BMI: %.2f\nCategory:%s".format(it, category)
        }
        return view
    }
}

