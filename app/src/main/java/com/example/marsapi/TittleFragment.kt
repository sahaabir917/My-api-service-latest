package com.example.marsapi

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.TypeAdapter
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
class TittleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tittle, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(AnotherApiService::class.java)

        api.fetchAlltypes(37).enqueue(object : Callback<List<Typedata>>{
            override fun onFailure(call: Call<List<Typedata>>, t: Throwable) {
                d("denial","Data retrived failure")
            }

            override fun onResponse(call: Call<List<Typedata>>, response: Response<List<Typedata>>
            ) {
                showData(response.body()!!)
            }

        })


    val newtypedata = Typedata(1,2,"asdhak","sadjkhasd")


        api.senddatatypes(newtypedata).enqueue(object : Callback<Typedata>{
            override fun onFailure(call: Call<Typedata>, t: Throwable) {
                d("dental","data send failure")
            }

            override fun onResponse(call: Call<Typedata>, response: Response<Typedata>) {
                d("dental", "data send success ${response.body()}")
            }
        })

    }



        private fun showData(typedata: List<Typedata>){
        anotherrecycler.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = TypesAdapter(typedata)
        }
        }
    }


