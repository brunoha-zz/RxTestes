package com.example.bruno.testex

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.generical_adapter.view.*


/**
 * Created by bruno on 28/06/18.
 */
class GenericalAdapter(val itens : List<String>,
                       val context : Context) : RecyclerView.Adapter<GenericalAdapter.GenericalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): GenericalAdapter.GenericalViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.generical_adapter,parent,false)
        return GenericalViewHolder(view)
    }

    override fun onBindViewHolder(holder: GenericalAdapter.GenericalViewHolder?, position: Int) {
          holder?.bindView(itens[position])
    }

    override fun getItemCount(): Int {
        return itens.size
    }

    class GenericalViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(item : String){
            val text = itemView.adapter_text
            text.text = item
        }
    }

}
