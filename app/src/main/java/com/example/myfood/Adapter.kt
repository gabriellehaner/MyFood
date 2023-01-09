package com.example.myfood

import DadosReceita
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.itens_lista.view.*

class Adapter (private val onClicked: () -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private lateinit var itens: List<DadosReceita>

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

    fun setDataSet (list: DadosReceita){
        this.itens = listOf(list)
    }


    class ReceitaViewHolder constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView){

      private val dadosTitulo = itemView.campolistareceita
        private val dadosTempo = itemView.campolistapreparo
//        val cardView = itemView.cardView


        fun bind(DadosReceita: DadosReceita, onClicked: () -> Unit){
            dadosTitulo.text = DadosReceita.titulo
            dadosTempo.text = DadosReceita.tempo

            itemView.setOnClickListener {
                onClicked()
            }
        }

    }

}