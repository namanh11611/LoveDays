package com.namanh.lovedays.features

data class Memory(val id: Int,
                  val title: String,
                  val description: String,
                  val day: Int,
                  val month: Int,
                  val year: Int) {
    companion object {
        fun empty() = Memory(0, "", "", 1, 1, 2020)
    }
}