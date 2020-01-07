package com.zijie.kotlinbase.generic

import android.annotation.TargetApi
import android.os.Build
import java.io.File
import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator

/**
 * Created by hezijie on 2019/12/30.
 */

class Outer{
    val a = 10

    /**
     * 嵌套类不持有外部类的引用
     */
    class Inner{
        fun num() = 2
        fun getNum():Int{
            return 1;
        }
    }

    /**
     * 内部类持有外部类的引用
     */
    inner class Inner2{
        val a = 11
        fun getNum():Int = this@Outer.a
    }

}

enum class Direction{
    NORTH,SOUTH,WEST,EAST
}

/**
 * 每一个枚举都是一个对象，都是枚举类的一个实例。
 */
enum class MyColor(val i:Int){
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

enum class ProtocolState{
    WAITING { override fun signal() = TALKING },
    TALKING { override fun signal() = WAITING };
    abstract fun signal(): ProtocolState
}

@TargetApi(Build.VERSION_CODES.N)
enum class IntDemo:BinaryOperator<Int>,IntBinaryOperator{
    PLUS{
        override fun apply(t: Int, u: Int): Int {
            return t + u
        }

    },
    TIMES{
        override fun apply(t: Int, u: Int): Int {
            return  t * u
        }
    };

    /**
     * 枚举类可以统一实现接口中的方法，也可以像上面的匿名内部类一样单独实现
     */
    override fun applyAsInt(left: Int, right: Int): Int {
        return apply(left,right)
    }
}

enum class RGB{
    RED,GREEN,BLUE
}
inline fun <reified T:Enum<T>> printAllValues(){
    println(enumValues<T>().joinToString { it.name })
}




@TargetApi(Build.VERSION_CODES.N)
fun main() {
//    val intArr:Array<Int> = arrayOf(1,2,3)
//    val any = Array<Any>(3){}
//    copy(intArr,any)
//
//    add(Com())
    val inner:Outer.Inner = Outer.Inner()
    println(inner.num())
    val  a = 13
    val b = 31
    for (f in IntDemo.values()){
        println("$f($a, $b) = ${f.apply(a, b)}")
    }
    println(IntDemo.valueOf("PLUS"))
    printAllValues<RGB>()
    val obj = object : A(1),B {
        override val i = 11
    }

    //直接创建一个没有任何基类的匿名内部类
    val obj2  = object {

    }
    val  g = singleClass.a
    SC.m = 100;
    val y = MyCl
    println(y.javaClass)

}

interface Factory<T>{
    fun create():T
}
//类型别名的使用
typealias MyCl = MyClassOne
class MyClassOne{

    companion object:Factory<MyClassOne>{

        override fun create(): MyClassOne {
            return MyClassOne()
        }

    }

}

/**
 * 对象声明
 */
object SC:C(){
    var m = 7;
}

object singleClass{
    var a = 10
}

open class C{
    private fun priFun() = object {
            val x :String = "x"
        }

    fun pubFun()= object {
            val m:String = "m"
        }


    fun  bar(){
        var a = priFun().x
//        val b = pubFun().m
    }
}



open class A(val a:Int){
    constructor():this(11){

    }
    open val i = a;
}

interface B{

}


class Com : Comparable<Int>{
    override fun compareTo(other: Int): Int {
        return 1;
    }

}
fun copy(from:Array<out Any> ,to:Array<Any>){
    assert(from.size == to.size)
    for (i in from.indices){
        to[i] = from[i]
    }
    println(to)

}


/**
 * 使用:表示泛型的上边界
 */
fun <T:Comparable<Int>> add(t:T){

}

/**
 * 当有多个上边界时
 */
fun <T>add2(t:T)where T:Comparable<Int>,T:CharSequence{

}