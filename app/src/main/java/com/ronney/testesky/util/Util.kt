package com.ronney.testesky.util

import android.content.Context

class Util {
    companion object {

        @JvmStatic
        fun getImageSource(context: Context, image: Int): String = "android.resource://" + context.packageName + "/" + image

    }
}