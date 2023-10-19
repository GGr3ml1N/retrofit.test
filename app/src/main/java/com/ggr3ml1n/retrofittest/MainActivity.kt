package com.ggr3ml1n.retrofittest

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.ggr3ml1n.retrofittest.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val vm: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vm.userLiveData.observe(this) {
            binding.apply {
                Picasso.get().load(it.image).into(iv)
                firstName.text = it.firstName
                lastName.text = it.lastName
            }
        }

        binding.button.setOnClickListener {
            binding.apply {
                vm.getUser(
                    username = userName.text.toString(),
                    password = password.text.toString()
                )
            }
        }
    }
}