package com.example.tp2githubactions

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tp2githubactions.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.message.text = getString(R.string.hello_message)
    }
}
