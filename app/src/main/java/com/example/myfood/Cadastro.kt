package com.example.myfood


import ReceitaDB
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.cadastro_fragment.*

class Cadastro : Fragment(R.layout.cadastro_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        view.findViewById<Button>(R.id.botaocadastrarreceita).setOnClickListener {
            validarCampos()
        }

    }

    private fun validarCampos() {
        if (tituloreceita.text.isEmpty()) {
            tituloreceita.setError("Preencha corretamente todos os campos")
        } else if (temporeceita.text.isEmpty()) {
            temporeceita.setError("Preencha corretamente todos os campos")
        } else if (textoingredientes.text.isEmpty()) {
            textoingredientes.setError("Preencha corretamente todos os campos")
        } else if (textopreparo.text.isEmpty()) {
            textopreparo.setError("Preencha corretamente todos os campos")
        } else {
            salvarReceita(
                Receita(
                    titulo = tituloreceita.text.toString(),
                    tempo = temporeceita.text.toString(),
                    ingredientes = textoingredientes.text.toString(),
                    mododepreparo = textopreparo.text.toString()
                )
            )

            findNavController().navigate(R.id.cadastro_para_home2)
        }
    }

    private fun salvarReceita(receita: Receita) {
        ReceitaDB.salvarReceita(receita)
    }

}