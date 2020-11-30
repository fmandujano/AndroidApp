package com.sae.miapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.sae.miapp.databinding.RegisterBinding
import com.sae.miapp.databinding.WebTestBinding

class Register : Fragment()
{
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<RegisterBinding>(inflater, R.layout.register, container, false )
        return binding.root
    }
}