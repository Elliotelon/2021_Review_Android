package com.elliot.step10scopefunction

data class WHAT(val name: String, val age: Int)

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
}