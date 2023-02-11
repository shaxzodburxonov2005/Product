package com.example.myproductall.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myproductall.R
import com.example.myproductall.databinding.FragmentAllBinding

class AllFragment : Fragment() {
    lateinit var binding: FragmentAllBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_all, container, false)
        binding = FragmentAllBinding.bind(view)




        return view
    }
}