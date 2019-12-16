package com.zijie.kotlinbase

/**
 * Created by  hezijie on 2019/12/13.
 */
fun main() {
    //val变量只可以赋值一次，只读变量，类似于java的final但不完全相同
    val j: Int = 2
    val k: Int;//延迟赋值
    k = 3
    val i = 1 //自动推断类型
    println("val i is $i j is $j k is $k")

    //关键字var
    var l: Int = 4
    println(" start var l is $l")
    l = 5;
    println("end var l is $l")

    println(sum(1, 2))
    //
    println("sum a + b = ${sum2(4, 5)}")
    val a: Int = 10
    //只有一个参数是可以不要大括号
    println("sum is $a ")

    println("void reture is ${sum3(6, 7)}")
//    strUses()
//    println("a And b max of ${maxOf(9, 10)}")
//    println("String to int ${parseInt("10")}")
//    println("sumadd 10 and 9 is ${sumAdd("10", "9a")}")
//
//    println("convert is ${convertType(11)}")
//    forUses()
//    whileUses()
//    println("when use is ${whenUses("jie")}")
//    inUses(1)
    listUses()
}

fun listUses(){
    var listOf = listOf("apple", "orange", "pinut")
    for (item in listOf){
        println("list is $item")
    }

    when{
        "orange " in listOf -> println("orange is in list")
        "pinut" in listOf -> println("pinut is in list")
    }
}

fun inUses(a: Int){
    val x = 9
    val y = 100
    if (a in x .. y){
        println("a is in range")
    }

    val list = listOf<String>("zi","jie","he")
    if (3 !in list.indices){
        println("num is no in list indices")
    }else{
        println("num is in list indices")
    }

    //遍历数列
    for (x in 1..10 step 1){
        println("step is $x")
    }
}

/**
 * when表达式的使用，类似于switch
 */
fun whenUses(a: Any): String {
    when (a) {
        1 -> return "one"
        2 -> return "two"
        3 -> return "three"
        "zi" -> return "hezijie"
    }
    return "default"
}


/**
 * 使用while循环
 */
fun whileUses() {
    val items = listOf("he", "zi", "jie", "hezijie")
    var index = 0
    while (index < items.size) {
        println("while item is " + items[index])
        index++
    }
}

/**
 * 使用for循环
 */
fun forUses() {
    val items = listOf("he", "zi", "jie", "hezijie")
    for (item in items) {
        println("item is " + item)
    }
    for (index in items.indices) {
        println("indices is $index item is ${items[index]}")
    }
}

/**
 * 使用类型检查和自动类型转换
 */
fun convertType(obj: Any): Int {
    if (obj !is String) {
        return -1;
    }
    return obj.length
}

fun sumAdd(arg1: String, arg2: String): Int {
    val a = arg1.toIntOrNull()
    val b = arg2.toIntOrNull()
    if (a == null || b == null) {
        return 0
    }
    return a * b
}

fun parseInt(s: String) = s.toIntOrNull()

fun maxOf(a: Int, b: Int) = if (a > b) a else b

/**
 * 字符串模板
 */
fun strUses() {
    val a = 1
    var s = "s is a"
    println("${s.replace("a", "was")}")
}

fun sum(a: Int, b: Int): Int {
    return a + b;
}

/**
 * 方法返回值只有一个语句时，可以这样写
 */
fun sum2(a: Int, b: Int) = a + b

/**
 * 返回值为空时，可以省略掉
 */
fun sum3(a: Int, b: Int): Unit {
    println("a+b is ${a + b}")
}