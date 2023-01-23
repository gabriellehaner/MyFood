package com.example.myfood

import ReceitaDB
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.cadastro_fragment.*
import kotlinx.android.synthetic.main.detalhes_fragment.*

class Detalhes : Fragment(R.layout.detalhes_fragment) {

    private val args: DetalhesArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        clickEdit()


        //Receber dados dos campos de cadastro
        val tituloreceita = view.findViewById<TextView>(R.id.recebertituloreceita)
        tituloreceita?.text = args.receita.titulo

        val temporeceita = view.findViewById<TextView>(R.id.recebertempodepreparo)
        temporeceita?.text = args.receita.tempo

        val receberingredientes = view.findViewById<TextView>(R.id.receberinngredientes)
        receberingredientes?.text = args.receita.ingredientes

        val receberpreparo = view.findViewById<TextView>(R.id.recebermododepreparo)
        receberpreparo?.text = args.receita.mododepreparo


        recebertituloreceita.isEnabled = false
        recebertempodepreparo.isEnabled = false
        receberinngredientes.isEnabled = false
        recebermododepreparo.isEnabled = false


        //Navegacao dos botoes
        view.findViewById<Button>(R.id.botaocvoltarhome_detalhes).setOnClickListener {
            ReceitaDB.deletarReceita(args.receita)
            findNavController().navigate(R.id.detalhes_para_consultar)
        }

        //Acao de atualizar a receita
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

    fun clickEdit() {
        botaoeditartitulo.setOnClickListener{
            recebertituloreceita.isEnabled = true
        }
        botaoeditartempo.setOnClickListener{
            recebertempodepreparo.isEnabled = true
        }
        botaoeditaringredientes.setOnClickListener{
            receberinngredientes.isEnabled = true
        }
        botaoeditarpreparo.setOnClickListener{
            recebermododepreparo.isEnabled = true
        }
    }

}