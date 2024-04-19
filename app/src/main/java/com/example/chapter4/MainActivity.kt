package com.example.chapter4

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.chapter4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goInputActivityButton.setOnClickListener {
            val intent = Intent(this, EditActivity::class.java)
            startActivity(intent)
        }
        binding.deleteButton.setOnClickListener {
            deleteDate()
        }
        binding.emergencyContactLayer.setOnClickListener {
             with(Intent(Intent.ACTION_VIEW)) {
                val phoneNumber = binding.emergencyContactValueTextView.text.toString()
                    .replace("-", "")
                 data = Uri.parse("tel:$phoneNumber")
                 startActivity(this)
            }
        }
    }
    private fun getDateUiUpdate() {
        with(getSharedPreferences(USER_INFORMATION, MODE_PRIVATE)) {
            binding.nameValueTextView.text = getString(NAME, "미정")
            binding.birthdateValueTextView.text = getString(BIRTHDATE, "미정")
            binding.bloodTypeValueTextView.text = getString(BLOOD_TYPE, "미정")
            binding.emergencyContactValueTextView.text = getString(EMERGENCY_CONTACT, "미정")
            val waring = getString(WARING, "")
            binding. warningTextView.isVisible = waring.isNullOrEmpty().not()
            binding.warningValueTextView.isVisible = waring.isNullOrEmpty().not()
            if (!waring.isNullOrEmpty()) {
                binding.warningValueTextView.text = waring
            }
        }
    }

    private fun deleteDate() {
        with(getSharedPreferences(USER_INFORMATION, MODE_PRIVATE).edit()) {
            clear()
            apply()
            getDateUiUpdate()
        }
        Toast.makeText(this, "초기화를 완료했습니다", Toast.LENGTH_LONG).show()
    }

    override fun onResume() {
        getDateUiUpdate()
        super.onResume()
    }
}