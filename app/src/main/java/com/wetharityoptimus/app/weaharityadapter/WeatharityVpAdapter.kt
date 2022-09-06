package com.example.weatherapi.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class WeatharityVpAdapter(fa : FragmentActivity, private val fragList : List<Fragment>) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = fragList.size

    override fun createFragment(position: Int): Fragment {
      return fragList[position]
    }
}