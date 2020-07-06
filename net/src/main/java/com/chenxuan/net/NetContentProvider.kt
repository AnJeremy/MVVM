package com.chenxuan.net

import com.chenxuan.common.base.BaseContentProvider

class NetContentProvider : BaseContentProvider() {
    override fun onCreate(): Boolean {
        context?.run {
            Api.getInstance().init(applicationContext)
        }
        return true
    }
}