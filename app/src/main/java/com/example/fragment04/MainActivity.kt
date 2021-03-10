package com.example.fragment04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.fragment04.fragments.ReceiveFragment
import com.example.fragment04.fragments.SendFragment

class MainActivity : AppCompatActivity() {

    private val toggleFragmentBtn: Button by lazy { findViewById(R.id.main_btn) }
    private var fragmentPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showFragment(createReceive(), addToBackStack = false)

        toggleFragmentBtn.setOnClickListener {
            when (fragmentPosition % 2) {
                0 -> showFragment(createSend())
                else -> showFragment(createReceive())
            }
            fragmentPosition++
        }
    }

    private fun showFragment(fragment: Fragment, addToBackStack: Boolean = true) {
        supportFragmentManager.commit {
            replace(R.id.container_fragment, fragment)
            if (addToBackStack) {
                addToBackStack(null)
            }
        }
    }

    private fun createSend() = SendFragment.newInstance(input = "this SEND fragment")
    private fun createReceive() = ReceiveFragment.newInstance(output = "this RECEIVE fragment")
}