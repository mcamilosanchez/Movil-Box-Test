package com.example.testmovilbox.domain.model

import org.junit.Assert.assertEquals
import org.junit.Test

class ProductModelTest {

    @Test
    fun givePrice_whenGetPrice_thenValidateFormat(){
        //Given price without format
        val price = null
        //When give a price
        val expectedPrice = "$ 0,00"
        //Then validate price
        val testPrice = price.formattedPrice()
        assertEquals(expectedPrice, testPrice)
    }
}