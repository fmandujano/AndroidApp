package com.sae.miapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.sae.miapp.databinding.LoginBinding
import com.sae.miapp.databinding.WebTestBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WebTest : Fragment()
{
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<WebTestBinding>(inflater, R.layout.web_test, container, false )

        setResponseString( binding )

        return binding.root
    }

    fun setResponseString(  binding: WebTestBinding )
    {
        binding.info.text = "Descargando datos..."

        Api.retrofitService.login("Pruebas", "19000").enqueue(
            object: Callback<UserProperty> {
                override fun onResponse(call: Call<UserProperty>, response: Response<UserProperty>) {
                    binding.info.text = "Bienvenido " +  response.body()?.user +
                            ", con apellido " + response.body()?.last_name + "\n" +
                            "Tienes "+response.body()?.xp + " puntos."
                }

                override fun onFailure(call: Call<UserProperty>, t: Throwable) {
                    binding.info.text = t.message
                }

            }
        )

        /*
        Api.retrofitService.getMensajePrueba().enqueue(
            object: Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    binding.info.text = response.body()
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    binding.info.text = "Error al conectar al servidor: "  + t.message
                }

            })

         */

    }
}
