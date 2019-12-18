package ru.waryozh.vehiclefinesprototype.welcome

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ru.waryozh.vehiclefinesprototype.R
import ru.waryozh.vehiclefinesprototype.wizard.WizardActivity

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
    }

    fun startWizardActivity(view: View) {
        startActivity(Intent(this, WizardActivity::class.java))
    }
}
