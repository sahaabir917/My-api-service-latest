package com.example.marsapi

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.marsapi.databinding.FragmentMarsfragmentBinding
import kotlinx.android.synthetic.main.fragment_marsfragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * A simple [Fragment] subclass.
 */
class Marsfragment : Fragment() {

    private lateinit var binding : FragmentMarsfragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentMarsfragmentBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_marsfragment,container,false)
      binding.button1.setOnClickListener {view : View ->
          Navigation.findNavController(view).navigate(R.id.action_marsfragment_to_footballFragment)
      }

        return binding.root



    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    val retrofit = Retrofit.Builder()
        .baseUrl("https://mars.udacity.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    val api = retrofit.create(ApiService::class.java)
        d("abc","success")

        api.fetchAllusers().enqueue(object : Callback<List<Marsdata>>{
            override fun onFailure(call: Call<List<Marsdata>>, t: Throwable) {
                d("denial","not responding")
            }

            override fun onResponse(call: Call<List<Marsdata>>, response: Response<List<Marsdata>>) {
                showData(response.body()!!)
            }
        })

    }

    private fun showData(marsdata: List<Marsdata>){
        recyclerview.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = MarsAdapter(marsdata)
        }
    }




}
