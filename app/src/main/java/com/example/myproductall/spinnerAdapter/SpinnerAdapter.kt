package com.example.myproductall.spinnerAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ArrayAdapter
import com.example.myproductall.R
import com.example.myproductall.databinding.ItemSpinnerBinding

class SpinnerAdapter(val list:ArrayList<String>,context: Context):
    ArrayAdapter<String>(context, R.layout.item_spinner,list) {
    fun getCustomView(
        position: Int, convertView: View?,
        parent: ViewGroup?
    ): View {
        var itemvie: View
        if (convertView == null) {
            itemvie =
                LayoutInflater.from(parent?.context).inflate(R.layout.item_spinner, parent, false)
        } else {
            itemvie = convertView
        }
        val bind = ItemSpinnerBinding.bind(itemvie)
        bind.tvSpiner.text = list[position]

        return itemvie

        }
    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getCustomView(position,convertView,parent)
    }
    override fun getCount(): Int {
        return list.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        return getCustomView(position,convertView,parent)
    }

}