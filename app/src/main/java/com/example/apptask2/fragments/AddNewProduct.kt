package com.example.apptask2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.apptask2.R


class AddNewProduct : Fragment() {

    private var addProductFragment: AddNewProduct?=null

    private lateinit var productName: EditText
    private lateinit var productPrice :EditText
    private lateinit var productQuantity: EditText
    private lateinit var addProduct: Button
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view: View? = null
        view = inflater.inflate(R.layout.fragment_add_new_product, container, false)

        productName = view.findViewById(R.id.addProductName)
        productPrice = view.findViewById(R.id.addProductPrice)
        productQuantity = view.findViewById(R.id.addProductQuantity)
        addProduct = view.findViewById(R.id.addProduct)
        progressBar = view.findViewById(R.id.progressBar)

        addProduct.setOnClickListener(){
            postNewProduct()
        }

        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onBackPressed()

    }

    fun postNewProduct(){
        // validation checks
        val name = productName.text.toString()
        val price = productPrice.inputType.toInt()
        val quantity = productQuantity.inputType.toInt()

        if(name == "" || price == null || quantity == null){
            Toast.makeText(requireContext(),"This field is required", Toast.LENGTH_LONG).show()
        }
        else{
            // here should go the implementation of post request to add new product
        }

    }

    fun onBackPressed(){
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // in here you can do logic when backPress is clicked
                val fm: FragmentManager? = childFragmentManager
                val ft: FragmentTransaction = fm!!.beginTransaction()

                ft.setCustomAnimations(R.anim.slide_in, R.anim.slide_in, R.anim.slide_in, R.anim.slide_in)
            }
        })
    }

}