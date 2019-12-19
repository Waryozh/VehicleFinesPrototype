package ru.waryozh.vehiclefinesprototype.overview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import ru.waryozh.vehiclefinesprototype.App
import ru.waryozh.vehiclefinesprototype.R
import ru.waryozh.vehiclefinesprototype.injection.OverviewActivityComponent
import javax.inject.Inject

class OverviewActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val overviewViewModel: OverviewViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(OverviewViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_overview)

        (application as App).appComponent
            .plus(OverviewActivityComponent.Module())
            .inject(this)
    }
}
