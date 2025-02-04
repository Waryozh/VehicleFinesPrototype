package ru.waryozh.vehiclefinesprototype.overview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_overview.*
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

        // Once we get to OverviewActivity, mark it as the activity that StartingActivity should start
        overviewViewModel.shouldShowOverview = true

        tv_overview_reg_number.text =
            overviewViewModel.regNumber ?: getString(R.string.overview_empty_placeholder)

        tv_overview_passport_number.text =
            overviewViewModel.passportNumber ?: getString(R.string.overview_empty_placeholder)

        tv_overview_driver_licence.text =
            overviewViewModel.driverLicence ?: getString(R.string.overview_empty_placeholder)
    }
}
