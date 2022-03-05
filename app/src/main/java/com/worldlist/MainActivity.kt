package com.worldlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.worldlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var  binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Navigation Bağlama
        val navHostFragment= supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment
        NavigationUI.setupWithNavController(binding.bottomNavigationView,navHostFragment.navController)
    }
}