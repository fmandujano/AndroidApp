package com.sae.miapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.sae.miapp.databinding.LoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int)
            {
                if( binding.emailField.text.length >=3)
                {
                    binding.loginButton.isEnabled = true
                }else{
                    binding.loginButton.isEnabled = false
                }
            }
        })


        binding.loginButton.setOnClickListener{view:View ->
            Log.d( getString(R.string.debug_tag), "Clic en boton de login")

            val user:String = binding.emailField.text.toString()
            val pass:String = binding.passField.text.toString()
            Api.retrofitService.login( user, pass).enqueue(
                object: Callback<UserProperty> {
                    override fun onResponse(
                        call: Call<UserProperty>,
                        response: Response<UserProperty>
                    ) {
                        //revisar si hubo error en usuario
                        if( response.body()?.error != "")
                        {
                            Toast.makeText(context,response.body()?.error, Toast.LENGTH_LONG).show()
                            binding.emailField.setText("")
                            binding.passField.setText("")
                        }
                        else {
                            //si no hubo error, navegar a la siguiente pantalla
                            val bundle:Bundle = Bundle()
                            bundle.putString("username",  response.body()?.user)
                            bundle.putString("lastname",  response.body()?.last_name)
                            bundle.putString("id",  pass)
                            bundle.putInt("xp", response.body()?.xp!!.toInt() )

                            view.findNavController().navigate(R.id.action_login_to_welcome, bundle)
                            //enviar datos a la sig pantalla que vienen en response.body()
                            //view.findNavController().graph.

                        }
                    }
                    //error de conexión a ala red
                    override fun onFailure(call: Call<UserProperty>, t: Throwable) {
                        Log.d(getString(R.string.debug_tag), "Error: " + t.message)
                        Toast.makeText(context, getString(R.string.ui_network_error), Toast.LENGTH_LONG).show()
                    }

                }
            )
            //view.findNavController().navigate(R.id.action_login_to_welcome)
        }

        binding.registerButton.setOnClickListener{view:View ->
            Log.d( getString(R.string.debug_tag), "Clic en boton de register")
            view.findNavController().navigate(R.id.action_login_to_register)
        }



        return binding.root


    }
}