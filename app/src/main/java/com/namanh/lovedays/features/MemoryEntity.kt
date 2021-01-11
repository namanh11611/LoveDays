package com.namanh.lovedays.features

data class MemoryEntity(val id: Int,
                        val title: String,
                        val description: String,
                        val day: Int,
                        val month: Int,
                        val year: Int) {
    fun toMemory() = Memory(id, title, description, day, month, year)
}