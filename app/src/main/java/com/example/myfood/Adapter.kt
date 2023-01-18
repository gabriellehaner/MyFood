package com.example.myfood

import ReceitaDB
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.itens_lista.view.*

class Adapter (private val onClicked: (Receita) -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private lateinit var itens: List<Receita>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return ReceitaViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.itens_lista, parent, false)

        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder){
            is ReceitaViewHolder -> {
                holder.bind(itens[position], onClicked)
//                holder.cardView.setOnClickListener{
//                    clickCategoria.clickCategoria(categoria)
//                }
            }
        }
    }

//    interface ClickCategoria{
//        fun clickCategoria(categoria: ClickCategoria)
//    }


    override fun getItemCount(): Int {
        return itens.size
    }

    fun setDataSet (list: List<Receita>){
        this.itens = list
    }


    class ReceitaViewHolder constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView){

      private val dadosTitulo = itemView.campolistareceita
        private val dadosTempo = itemView.campolistapreparo
//        val cardView = itemView.cardView


        fun bind(receita: Receita, onClicked: (Receita) -> Unit){
            dadosTitulo.text = receita.titulo
            dadosTempo.text = receita.tempo

            itemView.setOnClickListener {
                onClicked(receita)
            }
        }

    }

}