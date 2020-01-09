package com.zijie.kotlinbase

/**
 * Created by hezijie on 2020/1/8.
 */
fun main() {
//    val a = A()
//    a.add(b = 10)
//    a.set(10)
//
//    a.function1() { println("hezijie") }
//    a.function1(qux = { println("hezijie2")})
//    a.function1(3,qux ={ println("hezijie2")})
//    a.function2(b = 11,c = 12)
//    //*为展开操作符，表示将数组中的内容传递给方法
//    a.function3(*arrayOf("1","2","3"))
    var listOf = listOf(1, 2, 3)
    listOf.foo(1,2,combin = {
        m:Int,n:Int ->

        println("m = $m -- n = $n")
        m + n
    })

    nullDemo()
}

fun nullDemo(){
    var listOf = listOf("kotlin", null)
    for (i in listOf){
        val m  = i ?: "hezijie"
        m?.let { println(it) }
    }

    var a:String? = null
    var b = a?.length
    var c : Int? = b as? Int

}

fun <T,R> Collection<T>.foo(a:T,b:R,combin:(a:T,b:R)->R){

    var combin1 = combin(a, b)
    println("$combin1")
}

open class A {
    //方法的默认值
    open fun add( a:Int = 1,b:Int){
        println("职位：${a + b}")
    }

    fun set(a:Int,b:Int = 1){

    }

    fun function1(a:Int = 1,b:Int = 2,qux:()-> Unit){

    }

    fun function2(a:Int = 1,b:Int = 2,c:Int,d:Int = 4){

    }

    fun function3(vararg string: String){

    }
}

class B :A(){
    //重写方法不能有默认值
    override fun add(i:Int,b:Int){

    }
}