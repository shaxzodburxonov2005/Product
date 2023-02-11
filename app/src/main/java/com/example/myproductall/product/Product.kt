package com.example.myproductall.product

import android.widget.ImageView
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(
    var name: String? = null,
    var price: String? = null,
    var tayp: String? = null,
    var img: ImageView? = null,
    var number: String? = null,

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
)