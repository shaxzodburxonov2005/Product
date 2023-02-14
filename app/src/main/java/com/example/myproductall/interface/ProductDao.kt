package com.example.myproductall.`interface`

import androidx.room.*
import com.example.myproductall.product.Product
import com.example.myproductall.product.Tayp
import com.example.myproductall.product.User

@Dao
interface ProductDao {

    @Query("SELECT * FROM Product")
    fun getAllProducts(): List<Product>

    @Query("SELECT * FROM Taype")
    fun getAllTypes(): List<Tayp>

    @Insert
    fun addProduct(product: Product)
    @Insert
    fun addTyap(product: Product)

    @Update
    fun editProduct(product: Product)
    @Update
    fun editTyap(product: Product)

    @Delete
    fun deleteProduct(product: Product)
    @Delete
    fun deletTyap(product: Product)
}