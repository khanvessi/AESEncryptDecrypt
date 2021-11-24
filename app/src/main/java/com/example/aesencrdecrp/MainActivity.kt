package com.example.aesencrdecrp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.aesencrdecrp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var byteArr: ByteArray? = null

    val mAESEncryptDecrypt = AESEncryptDecrypt()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEncrypt.setOnClickListener(View.OnClickListener {
            val msgInEditText = binding.edtMsg.text.toString()
            if(!msgInEditText.isNullOrEmpty()){
                 byteArr = mAESEncryptDecrypt.encrypt(this, msgInEditText)
            }
        })

        binding.btnDecrypt.setOnClickListener(View.OnClickListener {
            byteArr?.let { it1 -> mAESEncryptDecrypt.decrypt(this, it1) }
        })
    }
}