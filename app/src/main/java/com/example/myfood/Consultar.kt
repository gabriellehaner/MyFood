package com.example.myfood

import ReceitaDB
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.consultar_fragment.*


class Consultar : Fragment(R.layout.consultar_fragment) {



    private lateinit var profileAdapter: Adapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        view.findViewById<Button>(R.id.botaovoltarlista).setOnClickListener {
            findNavController().navigate(R.id.consultar_para_home2)
        }


        initAdapter()
        populateItems()
//        clickCard()
    }

    private fun populateItems() {
        val dados = ReceitaDB.dadosReceita
        profileAdapter.setDataSet(dados)
    }

    private fun initAdapter() {

        profileAdapter = Adapter {receita ->
            clickCard(receita)
        }

        recyclerlista.layoutManager = LinearLayoutManager(requireContext())
        recyclerlista.adapter = profileAdapter

            //cli
    }

    private fun clickCard(receita: Receita) {
        findNavController().navigate(ConsultarDirections.consultarParaDetalhes(receita))
    }

}