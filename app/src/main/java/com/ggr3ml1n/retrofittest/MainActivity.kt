package com.ggr3ml1n.retrofittest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import com.ggr3ml1n.retrofittest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val vm: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vm.productLiveData.observe(this) {
            binding.tv.text = it.title
        }

        binding.b.setOnClickListener {
            vm.initialize()
        }
    }
}