package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragments.databinding.FragmentCitiesBinding

class CitiesFragment : Fragment() {

    private val cities = "Yurevichi,Gumist’a,Ptitsefabrika,Orekhovo,Birim,Priiskovyy"

    private var _binding: FragmentCitiesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCitiesBinding.inflate(inflater, container, false)
        binding.textView.text = cities
        return binding.root
    }

}