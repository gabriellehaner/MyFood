package com.example.myfood

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class Home : Fragment (R.layout.home_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        view.findViewById<ImageButton>(R.id.consultarbotao).setOnClickListener {
            findNavController().navigate(R.id.home2_para_consultar)
        }

        view.findViewById<ImageButton>(R.id.cadastrarbotao).setOnClickListener {
            findNavController().navigate(R.id.home2_para_cadastro)
        }


    }

}