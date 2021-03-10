package com.example.fragment04.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import android.widget.TextView
import com.example.fragment04.R


private const val OUTPUT = "output"

class ReceiveFragment : Fragment(R.layout.fragment_receive) {
    companion object {

        @JvmStatic
        fun newInstance(output: String) =
            ReceiveFragment().apply {
                arguments = Bundle().apply {
                    putString(OUTPUT, output)
                }
            }
    }

    private val outputTV:TextView by lazy { requireView().findViewById(R.id.output_text) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireArguments().let {
            val output =it.getString(OUTPUT)
            output?.let {
                outputTV.text = it
            }
        }

    }
}