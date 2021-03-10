package com.example.fragment04.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.fragment04.R

private const val INPUT = "input"

class SendFragment : Fragment(R.layout.fragment_send) {

    companion object {

        @JvmStatic
        fun newInstance(input: String) =
            SendFragment().apply {
                arguments = Bundle().apply {
                    putString(INPUT, input)
                }
            }
    }

    val inputTextView: TextView by lazy { requireView().findViewById(R.id.input_str) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireArguments().let {
            val input = it.getString(INPUT)
            input?.let {
                inputTextView.text = it
            }
        }
    }


}