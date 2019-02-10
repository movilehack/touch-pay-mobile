package com.movile.touchpay.presentation.signup

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.movile.touchpay.R

class ThirdStepFragment : Fragment() {
    private var listener: ThirdStepListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_third_step, container, false)
    }

    fun onNextStep() {
        listener?.onThirdStepInteraction()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ThirdStepListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface ThirdStepListener {
        // TODO: Update argument type and name
        fun onThirdStepInteraction()
    }

    companion object {
        @JvmStatic
        fun newInstance() = ThirdStepFragment()
    }
}
