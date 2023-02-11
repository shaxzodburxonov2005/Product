package com.example.myproductall.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myproductall.R
import com.example.myproductall.database.DataBase
import com.example.myproductall.databinding.FragmentTwoBinding
import com.example.myproductall.`interface`.ProductDao
import com.example.myproductall.product.Product

class TwoFragment : Fragment() {
    lateinit var binding: FragmentTwoBinding
    lateinit var dataBase: DataBase
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_two, container, false)
        binding = FragmentTwoBinding.bind(view)

        dataBase = DataBase.getInstance(requireContext())
        val product: ProductDao = dataBase.userDao()


        binding.SaveBtn.setOnClickListener {
            val name = binding.nomiTv.text.toString()
            val soni = binding.soniTv.text.toString()
            val narxi = binding.narxiTv.text.toString()
            val rast = binding.img

            product.addProduct(product = Product(name,narxi, tayp = null,rast,soni))

        }

        return view
    }
}