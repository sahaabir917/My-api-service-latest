package com.example.marsapi

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.fragment_football.*
import kotlinx.android.synthetic.main.fragment_marsfragment.*
import kotlinx.android.synthetic.main.fragment_tittle.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * A simple [Fragment] subclass.
 */
class FootballFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_football, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://128.199.183.164:8081/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(Football::class.java)

        api.getdata().enqueue(object : Callback<FootballList>{
            override fun onFailure(call: Call<FootballList>, t: Throwable) {
                d("Abir","Failed to retrive")
            }

            override fun onResponse(call: Call<FootballList>, response: Response<FootballList>) {
              d("Abir","succcess")
                showAllData(response.body()!!)

            }

//            override fun onResponse(call: Call<List<Marsdata>>, response: Response<List<Marsdata>>) {
//                showData(response.body()!!)
//            }

        })


    }



    private fun showAllData (footballList: FootballList){
        footballrecycler.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = FootballAdapter(footballList)
        }
    }





}
