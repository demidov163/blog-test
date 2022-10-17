package com.example.blog

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class NullableTest {
    data class Person(val country: Country?)
    data class Country(val code: String?)
    
    @Test
    fun nullableAndNonNullableReferenceTypeTest() {
        var a = "value"
        assertEquals(a.length, 5)

        var b: String? = "value"
        b = null
        assertNull(b)
    }

    @Test
    fun safeCallsTest() {
        var country = Country("DE")
        var person = Person(country)

        assertEquals("DE", person.country?.code)

        country = Country(null)
        person = Person(country)

        assertNull(person.country?.code)

        person = Person(null)

        assertNull(person.country?.code)
        System.out.println(person.country?.code)
    }

    @Test
    fun letMethodTest() {
       val names =  listOf("alex", null, "john")
       var count = 0
        names.forEach { it ->
            it?.let { count += it.length }
        }
       System.out.println("Count: $count")
    }

    @Test
    fun mapReduceMethodTest() {
        val names = listOf("alex", null, "boris")
        val reduce = names.filterNotNull()
            .map {
                it.length
            }
            .reduce { a: Int, b: Int -> a + b }
        System.out.println("Length sum: $reduce")
    }

    @Test
    fun runMethodTest() {
        val names = listOf("alex", null, "boris")
        var count = 0
        names.forEach{
            it?.run {
                count += this.length
            }
        }
        System.out.println("Length sum: $count")
    }
}


