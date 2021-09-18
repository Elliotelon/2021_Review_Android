package com.elliot.step10scopefunction

data class WHAT(val name: String, val age: Int)

fun main() {
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
}