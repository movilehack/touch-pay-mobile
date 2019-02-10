package com.movile.touchpay.presentation.receive

import android.content.Intent
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.movile.touchpay.R
import com.movile.touchpay.presentation.common.BaseActivity
import com.movile.touchpay.presentation.custom.CustomViewPager
import com.movile.touchpay.presentation.receipt.ReceiptActivity
import org.kodein.di.generic.instance

class ReceiveActivity :
    BaseActivity<ReceiveView>(),
    ReceiveView,
    ReceiveStepFragment.ReceiveStepListener,
    AuthenticateStepFragment.AuthenticateStepListener {

    override val layoutId: Int = R.layout.activity_receive
    override val presenter: ReceivePresenter by instance()

    private lateinit var mPager: CustomViewPager
    private val totalPages = 2

    private lateinit var nextButton: Button
    private lateinit var currentStepText: TextView
    private lateinit var totalStepsText: TextView

    private val signUpSteps = listOf(
        ReceiveStepFragment.newInstance(),
        AuthenticateStepFragment.newInstance()
    )

    override fun onCreate() {
        mPager = findViewById(R.id.signUpPager)

        val pagerAdapter = ScreenSlidePagerAdapter(supportFragmentManager, signUpSteps)
        mPager.adapter = pagerAdapter

        currentStepText = findViewById(R.id.txtCurrentStep)
        currentStepText.text = (mPager.currentItem + 1).toString()

        totalStepsText = findViewById(R.id.txtTotalSteps)
        totalStepsText.text = totalPages.toString()

        nextButton = findViewById(R.id.btnNext)
        nextButton.setOnClickListener { nextStep() }
    }

    override fun setPresenter() {
        presenter.attachView(this)
    }

    override fun showError(messageId: Int) {
    }

    override fun showError(messsage: String) {
    }

    override fun onReceiveStepInteraction() {
    }

    override fun onAuthenticateStepInteraction() {
    }

    override fun nextStep() {

        val currentFragment = signUpSteps[mPager.currentItem]

        if (currentFragment is ReceiveStepFragment) {
            currentFragment.onNextStep()
        } else if (currentFragment is AuthenticateStepFragment) {
            currentFragment.onNextStep()
        }

        if (mPager.currentItem != 0 ) {
            presenter.performReceive()
        } else {
            mPager.currentItem += 1
            if (mPager.currentItem != 0) {
                nextButton.text = "PAGAR"
            }
            currentStepText.text = (mPager.currentItem + 1).toString()
        }
    }

    override fun proceedToReceipt() {
        val intent = Intent(this, ReceiptActivity::class.java)
        startActivity(intent)
    }

    private inner class ScreenSlidePagerAdapter(fm: FragmentManager, private val fragmentList: List<Fragment>) :
        FragmentStatePagerAdapter(fm) {
        override fun getCount(): Int = fragmentList.size

        override fun getItem(position: Int): Fragment = fragmentList[position]
    }
}
