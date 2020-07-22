package com.chenxuan.common.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.chenxuan.common.R
import com.gyf.immersionbar.ktx.immersionBar

/**
 * @author cx
 */
abstract class BaseSimpleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getContentView())
        initViewModel()
        initImmersionBar()
        initView(savedInstanceState)
        initData(savedInstanceState)
    }

    private fun initImmersionBar() {
        immersionBar {
            barColor(R.color.colorPrimary)
        }
    }

    open fun initViewModel() {

    }

    abstract fun getContentView(): Int

    abstract fun initData(savedInstanceState: Bundle?)

    abstract fun initView(savedInstanceState: Bundle?)
}