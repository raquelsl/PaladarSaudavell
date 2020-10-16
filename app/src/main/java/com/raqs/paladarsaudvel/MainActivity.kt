package com.raqs.paladarsaudvel

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.raqs.paladarsaudvel.Adapter.receitaAdapter
import com.raqs.paladarsaudvel.model.Constants
import com.raqs.paladarsaudvel.model.Receita
import kotlinx.android.synthetic.main.activity_main.*
import com.raqs.paladarsaudvel.model.detalhesReceita as detalhesReceita


class MainActivity : AppCompatActivity() {
    private val listaprincipal = arrayListOf<Receita>(
        Receita("Panqueca saudavel", "Ovos, aveia, Banana", "Unte uma frigideira"),
        Receita(
            "Brigadeiro saudavel",
            "Leite desnatado, Cacau em pó, Xilitol",
            "em uma panela adicione"
        )

        )

     val receitaAdapter = receitaAdapter(this, listaprincipal, this::clicarExibirLista)

       private fun clicarExibirLista(receita: Receita) {
            val intent = Intent(this, detalhesReceita::class.java)
            intent.putExtra(Constants.NomeReceita, receita.NomeReceita)
            intent.putExtra(Constants.NomeIgredientes, receita.NomeIgredientes)
            intent.putExtra(Constants.ModoPreparo, receita.ModoPreparo)

        }


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)


            fab.setOnClickListener {
                val detalhesReceita = Intent(this, detalhesReceita::class.java)
                startActivity(detalhesReceita)
            }
        }
     override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
         listaprincipal.clear()
        savedInstanceState.getParcelableArrayList<Receita>(Constants.NomeReceita)?.let { listaprincipal.addAll(it) }
    }



    private fun setupAddButton() {
        fab.setOnClickListener {
            val detalhesReceita = Intent(this, detalhesReceita::class.java)
            detalhesReceita.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP

            fun startActivityForResult(detalhesReceita: Intent) {}
        }
    }
}


