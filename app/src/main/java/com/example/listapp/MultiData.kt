package com.example.listapp

data class MultiData(val aIcon: Int, val aName: String, val aTel: String, val type: Int) {
    companion object {
        const val TYPE_FAVORITE = 1
        const val TYPE_CONTACT = 2
    }
}

