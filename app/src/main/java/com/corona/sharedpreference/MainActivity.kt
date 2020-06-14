package com.corona.sharedpreference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    val menuTeks = arrayOf("Awal","halaman Web")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        view_pager.isUserInputEnabled = false
        view_pager.setAdapter(viewPagerAdapter(this))
        TabLayoutMediator(tab_layout,view_pager, TabLayoutMediator.TabConfigurationStrategy{tab,position->tab.text = menuTeks[position]}).attach()

    }

}