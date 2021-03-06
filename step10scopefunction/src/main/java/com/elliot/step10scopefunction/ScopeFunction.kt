package com.elliot.step10scopefunction

data class WHAT(var name: String, var age: Int)

fun main() {
    //let
    println("Case 1")
    var w: WHAT? = null
    val v = w?.let {
        println(it)
    } ?: "Known"
    println(v)
    println("Case 2")
    var W: WHAT? = WHAT("Dip2K", 43)
    val V = W?.let {
        println(it)
    } ?: "Known"
    println(V)

    println("--------------------------------------------")
    //also
    println("Case 1")
    var w1: WHAT? = null
    val v1 = w1?.also {
        println(it)
    } ?: "Known"
    println(v1)
    println("Case 2")
    var W1: WHAT? = WHAT("Dip2K", 44)
    val V1 = W1?.also {
        println(it)
    } ?: "Known"
    println(V1)

    println("--------------------------------------------")

    //apply
    val w3 = WHAT("Jackass", 16)
    val r = w3.apply {
        name = "Dip2K"
        age = 45
    }
    println(w3)
    println(r)

    println("--------------------------------------------")

    //with
    val w4 = WHAT("Jackass", 16)
    val r2 = w4?.let {
        with(it) {
            name = "Dip2K"
            age = 43
            "Good day!"
        }
    }
    println(w4)
    println(r2)

    println("--------------------------------------------")

    //run
    val v2 = run {
        val w5 = WHAT("Jackass", 16)
        w5
    }
    println(v2)
    val vv = v2.run {
        name = "Dip2K"
        age = 43
        "Good day !"
    }
    println(v2)
    println(vv)
}