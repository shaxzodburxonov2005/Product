package com.example.myproductall.fragment

import android.app.AlertDialog
import android.content.pm.PackageManager
import android.net.Uri
import android.nfc.Tag
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.example.myproductall.R
import com.example.myproductall.database.DataBase
import com.example.myproductall.databinding.DialogItemBinding
import com.example.myproductall.databinding.FragmentTwoBinding
import com.example.myproductall.`interface`.ProductDao
import com.example.myproductall.product.Product
import java.io.File
import java.io.FileOutputStream

class TwoFragment : Fragment() {
    lateinit var binding: FragmentTwoBinding
//    lateinit var dataBase: DataBase
    var imgUri:String?=null
    private val galleryPermission=registerForActivityResult(ActivityResultContracts.RequestPermission()){ granted->
        if (granted){
            getImageContent.launch("image/*")
        }

    }
    private val getImageContent=registerForActivityResult(ActivityResultContracts.GetContent()){uri->
        uri?:return@registerForActivityResult
        binding.img.setImageURI(uri)
        val stream=requireContext().contentResolver.openInputStream(uri!!)
        val file= File(requireContext().filesDir,"image.jpg")
        val outputStream=FileOutputStream(file)
        stream?.copyTo(outputStream)
        stream?.close()
        imgUri=file.absolutePath
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_two, container, false)
        binding = FragmentTwoBinding.bind(view)

//        dataBase = DataBase.getInstance(requireContext())
      //  val product: ProductDao = dataBase.userDao()


        binding.SaveBtn.setOnClickListener {
            val name = binding.nomiTv.text.toString()
            val soni = binding.soniTv.text.toString()
            val narxi = binding.narxiTv.text.toString().toInt()



//            product.addProduct(product = Product(name,narxi, tayp = null,rast,soni))

        }
        binding.btnImg.setOnClickListener {
            val customDialog=AlertDialog.Builder(requireContext()).create()
            val dialogView=layoutInflater.inflate(R.layout.dialog_item,binding.root,false
            )
            customDialog.setView(dialogView)

            val bind=DialogItemBinding.bind(dialogView)

            bind.img2.setOnClickListener {
                galleryPermission.launch(android.Manifest.permission.READ_EXTERNAL_STORAGE)
                customDialog.dismiss()
            }
            bind.img.setOnClickListener {
                if (allPermissonGranted()){
                    savedInstance()
                }else{
                    ActivityCompat.requestPermissions(
                        requireActivity(), REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS
                    )
                }
                customDialog.dismiss()
            }

            customDialog.show()

        }

        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<String>("key")
            ?.observe(
                viewLifecycleOwner
            ){result->
                binding.img.visibility=View.VISIBLE
                binding.img.setImageURI(Uri.parse(result))
                imgUri=result

            }



        return view
    }

    private fun savedInstance() {
        findNavController().navigate(R.id.camerFragment)
    }

    private fun allPermissonGranted()= Companion.REQUIRED_PERMISSIONS.all{
        ContextCompat.checkSelfPermission(
            requireContext(),it
        )==PackageManager.PERMISSION_GRANTED
    }
    companion object{
        private const val Tag="CameraXAPP"
        private const val REQUEST_CODE_PERMISSIONS=10
        private val  REQUIRED_PERMISSIONS= mutableListOf(
            android.Manifest.permission.CAMERA
        ).apply {
            if (Build.VERSION.SDK_INT<=Build.VERSION_CODES.P){
                add(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
            }
        }.toTypedArray()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode== REQUEST_CODE_PERMISSIONS){
            if (allPermissonGranted()){
                savedInstance()
            }else{
                Toast.makeText(requireContext(),
                    "Permissions not granted by the user",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
}