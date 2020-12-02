package com.sae.miapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.sae.miapp.databinding.LoginBinding
import com.sae.miapp.databinding.WelcomeBinding


class Welcome : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.welcome, container, false)
        val binding = DataBindingUtil.inflate<WelcomeBinding>(inflater, R.layout.welcome, container, false )

        //obtener el bundle
        val username = arguments?.getString("username")
        val lastName = arguments?.getString("lastname")
        val xpPoints = arguments?.getInt("xp")
        val userId = arguments?.getString("id")

        //modificar el mensaje de bienvenida
        binding.welcomeMessage.text = binding.welcomeMessage.text.toString() + ", " + username
        //info del usuario abajo de la imagen
        binding.userInfo.text = username + " " + lastName + "\n[" +userId + "]"


        //bindImage(binding.avatar, "http://juegodetalento.com/appify/image.jpg")
        bindImageHTTPS(binding.avatar, "https://thispersondoesnotexist.com/image")


        //boton envía a la pantalla de main menu
        binding.continueButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_welcome_to_mainMenu)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
