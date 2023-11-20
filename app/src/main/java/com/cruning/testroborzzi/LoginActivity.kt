package com.cruning.testroborzzi

import android.app.Activity
import android.os.Bundle
import android.widget.Button

class LoginActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcome_activity)
        val button = findViewById<Button>(R.id.login)
        button.text = "qwer"
    }
}