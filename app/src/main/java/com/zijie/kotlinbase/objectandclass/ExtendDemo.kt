package com.zijie.kotlinbase.objectandclass

import androidx.core.graphics.component1
import androidx.core.graphics.component2
import javax.security.auth.Subject

/**
 * Created by hezijie on 2019/12/18.
 */
open class BaseClass(a:Int){
    open val i = 100
    open fun function1(){

    }
}
class SonClass(val s:String ) : BaseClass(1){
    constructor(a:String,b:Int):this(a){

    }

}

class  Son2Class:BaseClass{
    constructor(a:String,b:Int):super(b){

    }
    final override fun function1(){

    }
}

open class Base(val name:String){
    init {
        println("基类的init方法执行了")

    }
    open val size:Int get() = name.length.also { println("size在Base类中的的初始化函数完成$it") }
}

class Derived(name:String,lastName:String):Base(name.capitalize().also { println("给父类传递的阐述$it") }){
    init {
        println("子类的初始化init方法执行了")
    }
    override val size  = (super.size + lastName.length).also { println("子类重写了父类的属性$it") }
}

open class Foo(){

    open val f = 1
    open fun function(){
        println("父类的方法执行了")
    }
}

class Bar:Foo(){
    val m = super.f + 1
    override fun function(){
        super.function()
    }

    inner class InnClass{
        fun hah(){
            //在内部类(inner class)的代码中, 可以使用 super 关键字加上外部类名称限定符: super@Outer 来访问外部类(outer class)的超类:
            super@Bar.function()
            println(m)
            function()
        }
    }
}

interface InterMember{
    fun function2(){
        println("function2被执行了")}
    fun  function(){}
}

/**
 * 当2个父类有相同的方法时，子类必须重写这个方法，自己来实现这个方法
 */
class Fruit :Foo(),InterMember{

    var allDefal:Int = 1
    override fun function() {
        //使用下面的方式可以确定到底重写的哪一个父类的方法
//        super<Foo>.function()
//        super<InterMember>.function()
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    var size :Int = 1
        get() { return allDefal} set(value) {
        println("size的set方法执行了$size")
        field = value
        println("2size的set方法执行了$field")}
    val m :Int get() {return  allDefal}
    var l:Int  = 10
    private set
    var n = 11
    set(value) {if (value >= 0) field = value}
}

/**
 * 抽象类中的属性默认就是open的
 */
abstract class AbClass() :  Foo(){

    //可以使用抽象方法覆盖父类的方法
     override abstract fun function()
}

fun <T> MutableList<T>.swap(t1:Int ,t2:Int ){
    val temp = this[t2]
    this[t2] = this[t1]
    this[t1] = temp
}

open class A{
    fun function() = "xiangyu"
}
class B:A(){

}

class MyTest{
    companion object{
        fun function1(){

        }
    }
    lateinit var subject: Fruit
     fun setUp(){
        subject = Fruit()
    }
    fun test(){
        subject.function2()
    }



}
fun A.function() = "zijie"
fun B.function() = "hezijiehao"
////可为空的接收者
fun Any?.toString():String{
    if (this == null){
        return "null"
    }
    return toString()
}
//扩展属性
val <T> List<T>.lastIndex : Int get() = size - 1
fun MyTest.Companion.function2(){

}

class O{
    fun function1(){

    }
}
class P{
    fun function1(){

    }
    fun function13(){

    }

    fun O.function12(){
        function1()
        this@P.function1()
        function13()
        doMore()
    }
    fun doMore(){

    }
}

data class Human(var name:String){
    var age:Int  = 0
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Human

        if (name != other.name) return false
        if (age != other.age) return false

        return true
    }



}

interface Source<out T>{
    fun  function():T
}

fun demo(s: Source<String>){
    var obj:Source<Any> = s
    var item = obj.function()
    println("item is any or string ${item.javaClass}")
}

class SO<out T>(val t:T) : Source<T>{
    override fun function(): T {
        return t
    }

}

fun main() {
    //测试子类和父类的初始化顺序
    val d = Derived("hezijie","liubang");
    val f:Fruit = Fruit();
    f.size = 19;
    val mytest:MyTest = MyTest()
    mytest.setUp()
//    if (mytest::subject.isInitialized){
//        mytest.test()
//    }
    var mutableListOf = mutableListOf(1, 2, 3)
    mutableListOf.swap(1,2)
    var a:B = B();
    println("a.function ${a.function()}")
    MyTest.function1();
    MyTest.function2()
    val human:Human = Human("zijie")
    val human2:Human = Human("zijie")
    human.age = 10
    human2.age = 18
    //执行的结果是true，这是因为只有name在equal函数中，除非重写equal方法
    println("human == human2 is ${human == human2}")
    val human3 = human.copy(name = "zilll")
    val (name) = human3
    println("name is ${human3.name}")

    demo(SO<String>("hezijie"))
}