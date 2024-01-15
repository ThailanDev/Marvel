package com.example.core_android.error

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.core_android.R
import com.example.core_android.databinding.ScreenOfErrorBinding

class ScreenOfErrorFragment : DialogFragment() {

    private val binding by lazy { ScreenOfErrorBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding.closeBtn.setOnClickListener {
            this.dismiss()
        }

        return binding.root
    }

    fun retryLoading(click: () -> Unit) {
        binding.retryBtn.setOnClickListener {
            click()
        }
    }

    override fun getTheme(): Int {
        return R.style.DialogTheme
    }
}