package com.corona.sharedpreference

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class viewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    private val jumlah_menu = 2
    override fun createFragment(position: Int): Fragment {
        return when(position){
            0-> realFragment()
            1->webFragment()
            else->realFragment()
        }
    }

    override fun getItemCount(): Int {
        return jumlah_menu
    }
}