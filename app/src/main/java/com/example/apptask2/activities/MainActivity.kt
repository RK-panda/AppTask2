package com.example.apptask2.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apptask2.R
import com.example.apptask2.fragments.ProductGrid

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.navHostFragment,ProductGrid(),"ProductGridFragment").commit()


    }

    override fun onBackPressed() {
        val navHost = supportFragmentManager.findFragmentById(R.id.navHostFragment)
        navHost?.let { navFragment ->
            navFragment.childFragmentManager.primaryNavigationFragment?.let { fragment ->
                if(fragment is ProductGrid){
                    finish()
                }
                else{
                    super.onBackPressed()
                }
            }
        }
        super.onBackPressed()
    }
}