package com.zijie.kotlinbase

/**
 * Created by hezijie on 2019/12/16.
 */
fun main() {
    val a = 1_111_111;
    println("num is $a")
    function1()
}

/**
 * 内部表达
 */
fun function1(){
    val a: Int = 100
    val boxedA : Int? = a
    val another: Int? = a
    println("=== is ${boxedA === another}")
    println(boxedA == another)
}

fun function2(){
    val a: Int = 10000
    println(a === a)
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a
    println(boxedA === anotherBoxedA)
}