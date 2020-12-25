package com.example.Wandroid.Test

import android.app.Dialog
import android.content.Context
import android.view.Gravity
import android.view.WindowManager
import com.example.Wandroid.R

object ShowD {
    private var Dailogs: Dialog? = null
    fun Show(con: Context) {
        Dailogs = Dialog(con)
        val attributes = Dailogs?.window?.attributes
        attributes?.width = WindowManager.LayoutParams.MATCH_PARENT
        attributes?.height = WindowManager.LayoutParams.MATCH_PARENT
        Dailogs?.window?.setGravity(Gravity.CENTER)
        Dailogs?.apply {
            setContentView(R.layout.dailog_layout)
            setCancelable(false)
            setCanceledOnTouchOutside(false)
            this
        }?.show()

    }

    fun cancel() {
        Dailogs?.dismiss()
    }

}