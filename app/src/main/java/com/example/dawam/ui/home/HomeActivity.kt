package com.example.dawam.ui.home

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.dawam.R
import com.example.dawam.databinding.ActivityHomeBinding
import com.example.dawam.ui.about.AboutUsFragment
import com.example.dawam.ui.contactUs.ContactUsFragment
import com.example.dawam.ui.submit.SubmitRequestFragment
import com.google.android.material.navigation.NavigationBarView

class HomeActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initBottomNav()
    }

    private fun initBottomNav() {
        viewBinding.bottomNav.setOnItemSelectedListener(object :NavigationBarView.OnItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {

                when (item.itemId) {
                    R.id.home -> {
                        showFragment(HomeFragment())
                    }
                    R.id.about_us -> {
                        showFragment(AboutUsFragment())
                    }
                    R.id.contact_us -> {
                        showFragment(ContactUsFragment())
                    }
                    R.id.submet -> {
                        showFragment(SubmitRequestFragment())
                    }
                }
                return true
            }

        })
        viewBinding.bottomNav.selectedItemId=R.id.home

    }

    fun showFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,fragment).commit()
    }

}