package com.example.myfood


import DadosReceita
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.cadastro_fragment.*

class Cadastro : Fragment(R.layout.cadastro_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        view.findViewById<Button>(R.id.botaocadastrarreceita).setOnClickListener {
            DadosReceita.titulo = tituloreceita.text.toString()
            DadosReceita.tempo = temporeceita.text.toString()
            DadosReceita.ingredientes = textoingredientes.text.toString()
            DadosReceita.mododepreparo = textopreparo.text.toString()

            if (tituloreceita.text.isEmpty()){
                tituloreceita.setError("Preencha corretamente todos os campos")
            } else if (temporeceita.text.isEmpty()){
                temporeceita.setError("Preencha corretamente todos os campos")
            } else if (textoingredientes.text.isEmpty()){
                textoingredientes.setError("Preencha corretamente todos os campos")
            } else if (textopreparo.text.isEmpty()){
                textopreparo.setError("Preencha corretamente todos os campos")
            } else
            findNavController().navigate(R.id.cadastro_para_home2)
        }

    }

}