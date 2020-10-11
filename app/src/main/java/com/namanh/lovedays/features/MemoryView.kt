package com.namanh.lovedays.features

import android.os.Parcel

class MemoryView(val id: Int,
                 val title: String,
                 val description: String,
                 val day: Int,
                 val month: Int,
                 val year: Int) {
//    constructor(parcel: Parcel) : this(parcel.readInt(), parcel.readString()!!)
}