package com.sae.miapp

import android.os.Bundle
import android.os.Debug
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.FragmentManager

import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(getString(R.string.debug_tag), "App creada");
        emailField.addTextChangedListener(  object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int)
            {
                Log.d(getString(R.string.debug_tag), "texto en emailField cambia");
                if( emailField.text.length > 1)
                    loginButton.isEnabled = true;
            }
        });
    }

    fun onValueChanged()
    {
        Log.d(getString(R.string.debug_tag) , "valor cambiado");
    }

    /*
    override fun onCreateOptionsMenu(menu: Menu): Boolean
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    public fun onLoginButtonClick(view:View)
    {
        //val fm = supportFragmentManager

    }

    public fun onRegisterButtonClick(view:View)
    {
        Log.d(getString(R.string.debug_tag), "click en boton de registro");
    }

    */
}
