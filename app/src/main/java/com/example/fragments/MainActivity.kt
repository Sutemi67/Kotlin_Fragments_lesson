package com.example.fragments

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container_view, CitiesFragment())
                .commit()
        }
        setOnclickListeners()
    }

    private fun setOnclickListeners() {
        binding.replaceCountryFragment.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, CountriesFragment())
                .setReorderingAllowed(true)
                .commit()
        }
        binding.replaceBackStackCountryFragment.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, CountriesFragment())
                .addToBackStack("countries")
                .setReorderingAllowed(true)
                .commit()
        }
    }
}