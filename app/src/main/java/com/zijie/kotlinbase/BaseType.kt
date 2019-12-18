package com.zijie.kotlinbase

/**
 * Created by hezijie on 2019/12/16.
 */
fun main() {
    val a = 1_111_111;
//    println("num is $a")
    function10()
}

/**
 * 返回与跳转
 */
fun function10(){
    //②使用标签局部返回
    arrayOf(1,2,3,4,5).forEach {
        if (it == 3){
            return@forEach //局部的返回
        }
        println("循环中的打印数据 $it")
    }
    //①初步使用标签
    println("循环的函数执行完毕了")
//    val s = person.name ?: return //是什么意思呢
    circleone@for(i in 1..100){
//        print("circle2+$i")
        circleTwow@for(i in 1.. 100){
//            print("circle1+$i")
            if (i == 99){
                break@circleone //使用标签标记来跳出哪个循环
            }
        }
    }

}

/**
 * for循环的使用
 */
fun function9(){
    for (i in 6 downTo  6 step 1){
        println("数字 + $i")
    }
    var arrayOf = arrayOf(11, 22, 33, 44)
    for ((i,j) in arrayOf.withIndex()){
        println("index is $i value is $j")
    }
}

/**
 * 关于when关键字的使用
 */
fun function8() {
    val a:Any = "a";
    when (a) {
        "1".toIntOrNull(), 2, 3 -> { //多个条件相同时使用,分割
            print("1")
            val a = 20
            println("   $a")
        }
        in 2..8 -> println("2") // 使用in判断是否在某个范围内
        10, 9 -> println("10")
        is Int -> println("是Int类型") //使用is判断是否是某种类型
        is String -> println("是String类型")
        else -> {
            println("else 执行了")
        }
    }
    //当没有参数传进来时，里面的判断条件必须是boolean值
    when{
        "a" is String -> println("")
        1 is Int -> println("是int类型")
        else -> println("else boolean中")
    }

    //当when作为表达式使用时
    val max = when (a) {
        "1".toIntOrNull(), 2, 3 -> { //多个条件相同时使用,分割
            print("1")
            val a = 20
            println("   $a")
            1
        }
        in 2..8 -> {
            println("2")
            2
        } // 使用in判断是否在某个范围内
        10, 9 -> {
            println("10")
            3
        }
        is Int -> {
            println("是Int类型")
            4
        } //使用is判断是否是某种类型
        is String -> {
            println("是String类型")
            5
        }
        else -> {
            println("else 执行了")
            6
        }
    }
    println("max is $max")
}

/**
 * if的使用
 */
fun function7() {
    val a = 1;
    val b = 2
    //if可以作为表达式使用，这个时候必须要有else语句
    var max = if (a > b) a else b

    max = if (a > b) {//代码段中最后一行代码的值就是返回值
        println(a)
        a
//         println(max) 最后一行了，需要合法的返回值
    } else {
        println(b)
        b
    }
}


/**
 * 字符串
 */
fun function6() {
    //字符串拼接时，第一个元素必须是字符串
//    val s: String = "abcde"
//    for (a in s){
//        print(a + " ----")
//    }
//    for (indices in s.indices){
//        print("\n${s[indices] + " ----"}" )
//    }
    //这样会删除|前面的空白
    val text = """Tell me and I forget.
        |Teach me and I remember.
        |Involve me and I learn.\n
        |(Benjamin Franklin)
    """.trimMargin("|")
    println(text)

    val price = """ \n """
}

/**
 * 数组
 */
fun function5() {
//    var arrayOf = arrayOf("he", "zi", 9)
//    arrayOf.forEach { println(it) }
//
//    var arrayOfNulls = arrayOfNulls<Any>(10)
//    arrayOfNulls.forEach { println(it) }
//    var array = Array(5, { i -> (i * i) })
//    array.forEach { println(it) }
    val i = 100uL
    var intArrayOf = intArrayOf(1, 2, 3)
    intArrayOf.forEach { print(it.toString() + "  ") }
    uintArrayOf(1u, 2u, 3u).forEach { print(it.toString() + "   ") }
}

/**
 * 字符
 */
fun function4() {
    val c: Char = '何'
    println("字符串转换测试${c.toInt()}")
    if (c in '0'..'9') {
        val sum = c.toInt() - '0'.toInt();//将数字字符转换成真正的数字，而不是他的编码号
    }
    val a: Char? = c
    val b: Char? = c
    println("a === b is ${a === b}")
}

fun function3() {
    val a: Byte = 1;
    val b: Int = a.toInt(); //不能直接将a直接赋值给b必须要使用显示类型转换
    val l = 1L + 3

    val x = (8 shr 2) and 0x000FF000
    println("16进制数是\n${0x000FF000}")
    println(x)
}

/**
 * 内部表达
 */
fun function1() {
    val a: Int = 128
    val boxedA: Int? = a
    val another: Int? = a
    println("=== is ${boxedA === another}")
    println(boxedA === another)
}

fun function2() {
    val a: Int = 10000
    println(a === a)
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a
    println(boxedA === anotherBoxedA)
}