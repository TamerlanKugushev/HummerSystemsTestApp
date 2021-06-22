package com.example.hummersystemstestapp

import com.example.hummersystemstestapp.presentation.ProductsFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {

    fun ProductsScreen() = FragmentScreen { ProductsFragment.newInstance() }

}