package com.sae.miapp

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.userpoints.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class UserPoints : Fragment()
{
    override fun onAttach(context: Context)
    {
        super.onAttach(context)
        Log.d(getString(R.string.debug_tag), "onAttach llamado")
    }
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        Log.d(getString(R.string.debug_tag), "onCreate llamado")
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View?
    {
        // {} llaves
        // [] corchetes
        // <> menor que, mayor que
        pointsText.text = "000";
        Log.d( getString(R.string.debug_tag), "setting points text ");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.userpoints, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        Log.d( getString(R.string.debug_tag), "onviewCreated");
        /*
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
         */
    }
}
