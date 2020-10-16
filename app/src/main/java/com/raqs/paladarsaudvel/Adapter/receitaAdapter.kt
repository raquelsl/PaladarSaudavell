package com.raqs.paladarsaudvel.Adapter

import android.content.Context
import android.content.res.TypedArray
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.raqs.paladarsaudvel.R
import com.raqs.paladarsaudvel.model.Receita
import kotlinx.android.synthetic.main.activity_detalhes_receita.view.*
import kotlin.reflect.KFunction2


class receitaAdapter (
           private val context: Context,

           private val receita: List<Receita>,

           private val callback: (Receita) -> Unit
   ) : RecyclerView.Adapter<receitaAdapter.ViewHolder>(){

class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val NomeReceita: TextView = view.nome_receita
    val NomeIgredientes: TextView = view.igredientes
    val ModoPreparo: TextView = view.modopreparo

}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutReference = LayoutInflater.from(parent.context).inflate(R.layout.receita_item, parent, false)
        val viewHolder = ViewHolder(layoutReference)

        viewHolder.itemView.setOnClickListener {
            val rec = receita[viewHolder.adapterPosition]
            callback(rec, viewHolder.adapterPosition)
        }
        return viewHolder
    }

    private fun callback(rec: Receita, adapterPosition: Int) {

    }

    override fun getItemCount(): Int = receita.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val(NomeReceita, NomeIgredientes, ModoPreparo) = receita[position]

        holder.NomeReceita.text = NomeReceita
        holder.NomeIgredientes.text = NomeIgredientes
        holder.ModoPreparo.text = ModoPreparo

    }
}
