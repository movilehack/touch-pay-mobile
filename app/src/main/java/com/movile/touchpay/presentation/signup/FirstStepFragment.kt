package com.movile.touchpay.presentation.signup

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.movile.touchpay.R

class FirstStepFragment : Fragment() {
    private var listener: FirstStepListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first_step, container, false)
    }

    fun onNextStep() {
        listener?.onFirstStepInteraction()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FirstStepListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface FirstStepListener {
        fun onFirstStepInteraction()
    }

    companion object {
        @JvmStatic
        fun newInstance() = FirstStepFragment()
    }
}
