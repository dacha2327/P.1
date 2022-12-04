
package com.dacha.paybex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import coil.Coil.enqueue
import com.dacha.paybex.RETROFIT.Retrofit
import com.dacha.paybex.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var imageAdapter = ImageAdapter(arrayListOf())
    private var page:Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClicker()
    }

    private fun initClicker() {
        with(binding){
            btnSearch.setOnClickListener{
                doRequest(++page)
            }

            btnCon.setOnClickListener{
                page = 1
                doRequest(page)
            }
        }
    }

    private fun ActivityMainBinding.doRequest(i: Int) {
        Retrofit.api.getImage(photoED.text.toString(), page = page)
            .enqueue(object : Callback<PixaModel> {
                override fun onResponse(call: Call<PixaModel>, response: Response<PixaModel>) {
                    if (response.isSuccessful) {
                        response.body()?.hits?.let {
                            it.forEach{
                                imageAdapter.addImage(it)
                            }
                            binding.rvPhoto.adapter = imageAdapter
                        }
                    }
                }

                override fun onFailure(call: Call<PixaModel>, t: Throwable) {
                    Log.e("ololo", "onFailure: ${t.message}")
                }

            })
    }
}