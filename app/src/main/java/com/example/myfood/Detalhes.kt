package com.example.myfood

import ReceitaDB
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class Detalhes : Fragment(R.layout.detalhes_fragment) {

    private val args: DetalhesArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val tituloreceita = view.findViewById<TextView>(R.id.recebertituloreceita)
        tituloreceita?.text = args.receita.titulo

        val temporeceita = view.findViewById<TextView>(R.id.recebertempodepreparo)
        temporeceita?.text = args.receita.tempo

        val receberingredientes = view.findViewById<TextView>(R.id.receberinngredientes)
        receberingredientes?.text = args.receita.ingredientes

        val receberpreparo = view.findViewById<TextView>(R.id.recebermododepreparo)
        receberpreparo?.text = args.receita.mododepreparo




        view.findViewById<Button>(R.id.botaocvoltarhome_detalhes).setOnClickListener {
            ReceitaDB.deletarReceita(args.receita)
            findNavController().navigate(R.id.detalhes_para_consultar)
        }

        view.findViewById<Button>(R.id.botao_atualizar).setOnClickListener {
            ReceitaDB.alterarReceita(args.receita, Receita(
                titulo = tituloreceita.text.toString(),
                tempo = temporeceita.text.toString(),
                ingredientes = receberingredientes.text.toString(),
                mododepreparo = receberpreparo.text.toString()
            ))
            findNavController().navigate(R.id.detalhes_para_consultar)
        }

    }

}