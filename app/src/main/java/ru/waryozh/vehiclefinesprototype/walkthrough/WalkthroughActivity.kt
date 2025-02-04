package ru.waryozh.vehiclefinesprototype.walkthrough

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_walkthrough.*
import ru.waryozh.vehiclefinesprototype.App
import ru.waryozh.vehiclefinesprototype.R
import ru.waryozh.vehiclefinesprototype.injection.WalkthroughActivityComponent
import ru.waryozh.vehiclefinesprototype.overview.OverviewActivity
import javax.inject.Inject

private const val NUM_PAGES = 6

class WalkthroughActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val walkthroughViewModel: WalkthroughViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(WalkthroughViewModel::class.java)
    }

    private lateinit var viewPager: ViewPager2

    private val fragmentStringArray = arrayOf(
        R.string.walkthrough_push_notifications,
        R.string.walkthrough_pay_via_app,
        R.string.walkthrough_discount,
        R.string.walkthrough_bank_receipt,
        R.string.walkthrough_guarantee,
        R.string.walkthrough_observe_rules
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walkthrough)

        (application as App).appComponent
            .plus(WalkthroughActivityComponent.Module())
            .inject(this)

        viewPager = findViewById(R.id.vp_walkthrough)

        val pagerAdapter = ScreenSlidePagerAdapter(this)
        viewPager.adapter = pagerAdapter

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                if (position != NUM_PAGES - 1) {
                    walkthrough_bottom_bar.visibility = View.VISIBLE

                    // Mark the dot corresponding to the current page as selected,
                    // and its neighbours as deselected.
                    // We don't need to recolour non-neighbouring dots,
                    // because we can only move one page at a time,
                    (dot_container_walkthrough.getChildAt(position) as ImageView).setImageResource(R.drawable.dot_selected)
                    (dot_container_walkthrough.getChildAt(position - 1) as? ImageView)?.setImageResource(R.drawable.dot_default)
                    (dot_container_walkthrough.getChildAt(position + 1) as? ImageView)?.setImageResource(R.drawable.dot_default)

                    btn_walkthrough_proceed.visibility = View.INVISIBLE
                } else {
                    walkthrough_bottom_bar.visibility = View.INVISIBLE
                    btn_walkthrough_proceed.visibility = View.VISIBLE
                }
            }
        })

        iv_walkthrough_arrow.setOnClickListener {
            viewPager.setCurrentItem(viewPager.currentItem + 1, true)
        }

        btn_walkthrough_proceed.setOnClickListener {
            startActivity(Intent(this, OverviewActivity::class.java))
            finish()
        }

        // Once we get to WalkthroughActivity, mark it as the activity that StartingActivity should start
        walkthroughViewModel.shouldShowWalkthrough = true
    }

    override fun onBackPressed() {
        if (viewPager.currentItem == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed()
        } else {
            // Otherwise, select the previous step.
            viewPager.currentItem--
        }
    }

    private inner class ScreenSlidePagerAdapter(activity: AppCompatActivity) :
        FragmentStateAdapter(activity) {
        override fun getItemCount(): Int = NUM_PAGES

        override fun createFragment(position: Int): Fragment =
            WalkthroughFragment.create(fragmentStringArray[position])
    }
}
