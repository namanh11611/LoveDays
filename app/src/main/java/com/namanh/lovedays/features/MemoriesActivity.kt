package com.namanh.lovedays.features

import android.content.Context
import android.content.Intent
import com.namanh.lovedays.core.base.BaseActivity

class MemoriesActivity : BaseActivity() {

    companion object {
        fun callingIntent(context: Context) = Intent(context, MemoriesActivity::class.java)
    }

    override fun fragment() = MemoriesFragment()

}