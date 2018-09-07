package com.edandaniel.demofragment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.Button
import kotlinx.android.synthetic.main.activity_back_stack.*

class BackStackActivity : AppCompatActivity() {

    private var btnFrag1WithBack: Button? = null
    private var btnFrag2WithBack: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_back_stack)

        button1.setOnClickListener{
            val firstFragment = FirstFragment()
            val bundle = Bundle()
            bundle.putString("message","I'm the First!!! xDDD")
            firstFragment.arguments = bundle
            swapFragment(firstFragment,"frag1")
        }

        button2.setOnClickListener{
            val secondFragment = SecondFragment()
            val bundle = Bundle()
            bundle.putString("message","Sono il secondo frammento")
            secondFragment.arguments = bundle
            swapFragment(secondFragment,"frag2")
        }
    }

    private fun swapFragment(fragment: Fragment, tag:String){
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.containerFragment, fragment)
        ft.addToBackStack(tag) // back button now do stuff
        ft.commit()
    }
}
