package com.sae.miapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.sae.miapp.databinding.LoginBinding

class Login : Fragment()
{
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.login, container, false)
        val binding = DataBindingUtil.inflate<LoginBinding>(inflater, R.layout.login, container, false )

        binding.emailField.addTextChangedListener(  object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d(getString(R.string.debug_tag), "texto en emailField cambia");

                if( binding.emailField.text.contains("@")){
                    binding.loginButton.isEnabled = true
                }else{
                    binding.loginButton.isEnabled = false
                }

            }
        })


        binding.loginButton.setOnClickListener{view:View ->
            Log.d( getString(R.string.debug_tag), "Clic en boton de login")
            view.findNavController().navigate(R.id.action_login_to_welcome)
        }

        return binding.root


    }
}