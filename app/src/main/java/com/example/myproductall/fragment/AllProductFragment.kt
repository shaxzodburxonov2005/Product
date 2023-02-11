package com.example.myproductall.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myproductall.R
import com.example.myproductall.databinding.FragmentAllBinding
import com.example.myproductall.databinding.FragmentAllProductBinding

class AllProductFragment : Fragment() {
    lateinit var binding: FragmentAllProductBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_all_product, container, false)
        binding = FragmentAllProductBinding.bind(view)



        return view
    }
}