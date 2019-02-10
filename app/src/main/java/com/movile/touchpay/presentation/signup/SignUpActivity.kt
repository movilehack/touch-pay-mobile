package com.movile.touchpay.presentation.signup

import android.content.Intent
import android.net.Uri
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.movile.touchpay.R
import com.movile.touchpay.presentation.common.BaseActivity
import com.movile.touchpay.presentation.custom.CustomViewPager
import com.movile.touchpay.presentation.main.MainActivity
import org.kodein.di.generic.instance

class SignUpActivity : BaseActivity<SignUpView>(),
    SignUpView,
    FirstStepFragment.FirstStepListener,
    SecondStepFragment.SecondStepListener,
    ThirdStepFragment.ThirdStepListener {

    override val layoutId: Int = R.layout.activity_sign_up
    override val presenter: SignUpPresenter by instance()

    private lateinit var mPager: CustomViewPager
    private val totalPages = 3

    private lateinit var nextButton: Button
    private lateinit var currentStepText: TextView
    private lateinit var totalStepsText: TextView

    private val signUpSteps = listOf(
        FirstStepFragment.newInstance(),
        SecondStepFragment.newInstance(),
        ThirdStepFragment.newInstance()
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

    override fun onFirstStepInteraction() {
        Log.d("XABLAU", "Data from first step")
    }

    override fun onSecondStepInteraction() {
        Log.d("XABLAU", "Data from second step")
    }

    override fun onThirdStepInteraction() {
        Log.d("XABLAU", "Data from third step")
    }

    override fun setPresenter() {
        presenter.attachView(this)
    }

    override fun showError(messageId: Int) {
    }

    override fun showError(messsage: String) {
    }

    override fun nextStep() {
        val currentFragment = signUpSteps[mPager.currentItem]

        if (currentFragment is FirstStepFragment) {
            currentFragment.onNextStep()
        } else if (currentFragment is SecondStepFragment) {
            currentFragment.onNextStep()
        } else if (currentFragment is ThirdStepFragment) {
            currentFragment.onNextStep()
        }

        if (mPager.currentItem == totalPages - 1) {
            presenter.performSignUp()
        } else {
            mPager.currentItem += 1
            if (mPager.currentItem != 1) {
                nextButton.text = "Cadastrar"
            }
            currentStepText.text = (mPager.currentItem + 1).toString()
        }
    }

    override fun proceedToMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private inner class ScreenSlidePagerAdapter(fm: FragmentManager, private val fragmentList: List<Fragment>) :
        FragmentStatePagerAdapter(fm) {
        override fun getCount(): Int = fragmentList.size

        override fun getItem(position: Int): Fragment = fragmentList[position]
    }

}
