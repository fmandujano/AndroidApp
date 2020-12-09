package com.sae.miapp

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.sae.miapp.databinding.FragmentBlankBinding
import com.sae.miapp.databinding.LoginBinding


/*
    Pantalla con ejemplo de reproducción de audio
 */

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentBlankBinding>(inflater, R.layout.fragment_blank, container, false )

        var mediaPlayer: MediaPlayer? = MediaPlayer.create(context, R.raw.moombahton_trance)
        mediaPlayer?.start()

        binding.buttonStop.setOnClickListener{ view:View ->
            mediaPlayer?.stop()
        }

        binding.buttonPlay.setOnClickListener{ view:View ->
            mediaPlayer?.start()
        }

        return binding.root
    }
}