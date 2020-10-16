package com.raqs.paladarsaudvel.model

import android.app.Activity
import android.app.Activity.RESULT_CANCELED
import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.support.v7.app.AppCompatActivity
import com.raqs.paladarsaudvel.R
import kotlinx.android.synthetic.main.activity_detalhes_receita.*



class detalhesReceita : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_receita)
    }


    override fun onStart() {
        super.onStart()
        dadosEdicao()
        ButtonSave()
    }

    private fun dadosEdicao() {
        val intent = intent
        nome_receita.setText(Constants.NomeReceita)
        igredientes.setText(Constants.NomeIgredientes)
        modopreparo.setText(Constants.ModoPreparo)

    }

    private fun ButtonSave(){
        buttonSalvar.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra(Constants.NomeReceita, if(isValidString(nome_receita.text.toString())) nome_receita.text.toString() else "")
            resultIntent.putExtra(Constants.NomeIgredientes, if(isValidString(igredientes.text.toString())) igredientes.text.toString() else "")
            resultIntent.putExtra(Constants.ModoPreparo, if(isValidString(modopreparo.text.toString())) modopreparo.text.toString() else "")
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
    private fun isValidString(value: String) = !value.isNullOrEmpty()
}




