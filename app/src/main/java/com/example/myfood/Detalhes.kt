package com.example.myfood

import DadosReceita
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.navigation.fragment.findNavController

class Detalhes : Fragment(R.layout.detalhes_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tituloreceita = view?.findViewById<TextView>(R.id.recebertituloreceita)
        tituloreceita?.text = DadosReceita.titulo

        val temporeceita = view?.findViewById<TextView>(R.id.recebertempodepreparo)
        temporeceita?.text = DadosReceita.tempo

        val receberingredientes = view?.findViewById<TextView>(R.id.receberinngredientes)
        receberingredientes?.text = DadosReceita.ingredientes

        val receberpreparo = view?.findViewById<TextView>(R.id.recebermododepreparo)
        receberpreparo?.text = DadosReceita.mododepreparo


        view.findViewById<Button>(R.id.botaocvoltarhome_detalhes).setOnClickListener {
            findNavController().navigate(R.id.detalhes_para_consultar)
        }




    }

}