package com.zijie.kotlinbase.generic

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

fun main() {
//    val intArr:Array<Int> = arrayOf(1,2,3)
//    val any = Array<Any>(3){}
//    copy(intArr,any)
//
//    add(Com())
    val inner:Outer.Inner = Outer.Inner()
    println(inner.num())
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