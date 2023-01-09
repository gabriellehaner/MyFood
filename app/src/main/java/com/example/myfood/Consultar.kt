package com.example.myfood

import DadosReceita
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.consultar_fragment.*
import kotlinx.android.synthetic.main.consultar_fragment.view.*
import kotlinx.android.synthetic.main.itens_lista.*


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
        val dados = DadosReceita
        profileAdapter.setDataSet(dados)
    }

    private fun initAdapter() {

        profileAdapter = Adapter(
            { clickCard() }
        )

        recyclerlista.layoutManager = LinearLayoutManager(requireContext())
        recyclerlista.adapter = profileAdapter

            //cli
    }

    private fun clickCard() {
        findNavController().navigate(R.id.consultar_para_detalhes)
    }

}