package com.example.welcomepage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.net.URL

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val result = URL("https://android-kotlin-fun-mars-server.appspot.com/realestate").readText()
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

}
