package com.example.listapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listapp.databinding.ActivityMainBinding
import telAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataList = arrayListOf<MultiData>()
        dataList.add(MultiData(R.drawable.user,"홍길동", "010-12345678", MultiData.TYPE_FAVORITE))
        dataList.add(MultiData(R.drawable.user,"정도균", "010-12151555", MultiData.TYPE_FAVORITE))
        dataList.add(MultiData(R.drawable.user,"김씨", "010-12155155", MultiData.TYPE_FAVORITE))
        dataList.add(MultiData(R.drawable.user,"아무개", "010-12515155", MultiData.TYPE_CONTACT))
        dataList.add(MultiData(R.drawable.user,"최씨", "010-12341551", MultiData.TYPE_CONTACT))
        dataList.add(MultiData(R.drawable.user,"이씨", "010-12345676", MultiData.TYPE_CONTACT))
        dataList.add(MultiData(R.drawable.user,"박씨", "010-12345677", MultiData.TYPE_CONTACT))
        dataList.add(MultiData(R.drawable.user,"민씨", "010-12145888", MultiData.TYPE_CONTACT))
        dataList.add(MultiData(R.drawable.user,"곽씨", "010-12185181", MultiData.TYPE_CONTACT))
        dataList.add(MultiData(R.drawable.user,"명씨", "010-11111111", MultiData.TYPE_FAVORITE))

        val favoriteList = dataList.filter { it.type == MultiData.TYPE_FAVORITE }
        val contactList = dataList.filter { it.type == MultiData.TYPE_CONTACT }

        binding.recyclerView.adapter = telAdapter(favoriteList)
        binding.recyclerView2.adapter = telAdapter(contactList)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView2.layoutManager = LinearLayoutManager(this)

    }
}