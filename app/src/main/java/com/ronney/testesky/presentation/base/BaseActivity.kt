package com.ronney.testesky.presentation.base

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.include_toolbar.*

open class BaseActivity: AppCompatActivity() {

    protected fun toolBar(toolbar: Toolbar, titleIdRes: Int, showBackButton: Boolean = false) {
        toolbar.title = getString(titleIdRes)
        setSupportActionBar(toolbarMain)

        if (showBackButton)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}