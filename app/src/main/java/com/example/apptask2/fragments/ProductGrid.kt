package com.example.apptask2.fragments

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apptask2.R
import com.example.apptask2.adapters.HomeAdapter
import com.example.apptask2.home.HomeViewModel
import com.example.apptask2.models.PostProduct
import com.example.apptask2.models.ReturnedResults
import com.example.apptask2.models.ShowProducts
import com.example.apptask2.retrofit.ApiInterface
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback as Callback


class ProductGrid : Fragment() {

    private var productGridFragment: ProductGrid?=null
    private lateinit var goAddProductBtn:Button
    private lateinit var recyclerView:RecyclerView
    private lateinit var blankImage:ImageView
    private lateinit var progressBar:ProgressBar
    private lateinit var apiInterface:ApiInterface
    private lateinit var viewModel:HomeViewModel
    private lateinit var adapter: HomeAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }

    }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view:View?=null
        var view2:View?=null
        view = inflater.inflate(R.layout.fragment_product_grid, container, false)
        view2 = inflater.inflate(R.layout.row_card_item, container , false)

        goAddProductBtn = view.findViewById(R.id.goToAddProduct)
        recyclerView = view.findViewById(R.id.recyclerView)
        progressBar = view.findViewById(R.id.progressBar)
        blankImage = view2.findViewById(R.id.imageProduct)

        goAddProductBtn.setOnClickListener{
            childFragmentManager.beginTransaction().replace(R.id.navHostFragment, AddNewProduct(), "AddNewProductFragment").addToBackStack(null).commit()
        }
        roundImage()

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBackPressed()
        viewModelAdapter()
    }

    fun viewModelAdapter(){
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        initAdapter()
        viewModel.getProductsData()

        viewModel.postModelLiveData?.observe(this, Observer {
            if(it != null){
                progressBar.visibility = View.VISIBLE
                adapter.setData(it as ArrayList<ReturnedResults<PostProduct>>)
            }
            else{
                Toast.makeText(requireContext(),"Something went wrong",Toast.LENGTH_SHORT).show()
            }
            progressBar.visibility = View.GONE
        })
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

    fun roundImage(){
        val img = BitmapFactory.decodeResource(resources, R.drawable.image_blank)
        val round = RoundedBitmapDrawableFactory.create(resources, img)

        round.isCircular = true
        blankImage.setImageDrawable(round)
    }


    private fun initAdapter(){
        adapter = HomeAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

    }
}

