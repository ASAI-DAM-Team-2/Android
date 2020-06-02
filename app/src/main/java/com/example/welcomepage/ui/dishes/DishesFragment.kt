package com.example.welcomepage.ui.dishes

import ApixuApiService
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.welcomepage.R
import kotlinx.android.synthetic.main.fragment_dishes.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass.
 */
class DishesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dish_recycler, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val apiService = ApixuApiService()

        GlobalScope.launch(Dispatchers.Main) {
            val dishesResponse = apiService.getDishes().await()
            dishesResponse.forEach {

            }
            textView.text = dishesResponse.toString();
        }
    }

}
