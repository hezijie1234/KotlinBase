package com.zijie.kotlinbase

import java.lang.Double.NaN

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
//    listUses()
//    rangeTest()
//    studyWhile()
//    fooFlag()
//    var stu = Student("hezijie",18)
//    var son = Son("haha",28);
//    son.testOpen()
//    Father.testCompanion()
//    var son2 = Son2("zijie")
//    var me = Me("zijie","he");
    val mut: MutableList<Int> = mutableListOf(2,3,4,5,6)
    mut.swap(2,3)
    for ((index,value) in mut.withIndex()){
        println("element $index is $value")
    }
    var any: Any?
    any = Any()
    println("money is ${any.money}")
    any.money = 900
    println("money is ${any.money}")
    any = null;
    println("测试可为空的及守着${any.toString(1)}")
    var obj = Object()
    Object.fun1()
    Object.testFun1()

}
fun Object.Companion.testFun1(){
    println("这个是同伴对象的扩展函数testFun1方法")
}
class Object{
    companion object{
        fun fun1(){
            println("同伴对象里的fun1方法执行了")
        }
    }
}

var Any.money: Int
get() = 10
    set(value) {}


fun Any?.toString( i:Int):String{
    if (this == null){
        return "null"
    }
    return toString()
}

fun <T> MutableList<T>.swap(index1: Int ,index2: Int){
    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp

}

open class Father2{

}

class Son3 : Father2() {

}


interface Named{
    val name: String
}

interface Person:Named{
    var firstName: String
    val secondName: String
    override val name: String
        get() = "hezijie"
}
class Me(override var firstName: String, override var secondName: String):Person{
    override lateinit var name: String
    var age: Int = 10
       get
    private set
}

interface OnInterface{
     val name: String
    get() = "hezijie"
    var age: Int
    fun initfoo(){
        age = 10
    }

}

class  Son2:Father{
     lateinit var age: String;
    constructor():super("zijie")
    constructor(name: String):this(){
        age = "18"

        println("测试age ${age.length}")

    }

    override fun testOpen() {
        super.testOpen()
        lateinit var height: String
        height = "180"
    }
}

class Son( name: String,val age: Int):Father(name.also {  println("Argument for Base: $it")  }),IBase{
    companion object{
        const val m: Int = 10
    }
    override val fatherAge: Int
        get() = super.fatherAge.also { println("Initializing Son fatherAge") }

    var gg: String = "zijie"
    get
    set(value) {
        println("设置一个新的值")
        fatherAge.toString() + "zijie"
        "haha"
    }

    init { println("Initializing Son")
        println("mother is $mother")
    }
    constructor(name: String): this(name,18){

    }

    override fun testOpen() {
        super<Father>.testOpen()
        super<IBase>.testOpen()
    }

    inner class Baz{
        var mother: String = "ee"
        fun test(){
            super@Son.mother
        }
    }
}
interface IBase{
    fun testOpen(){

    }
}

open class Father(var name: String){
    open  val fatherAge: Int = 10.also {  println("Initializing size in Base: $it") }
    open var mother: String = "zhongguo".also { println("mother initialize over") }
    companion object {
        fun testCompanion(){

        }
    }
    init {
        println("Initializing Base")
    }
    constructor():this("zijie"){

    }
    constructor( name: String, age: Int):this(){

    }

    open fun testOpen(){

    }

}

class Student(var name :String,var age: Int,val height: Int){

    init {
        if (height == 0){
            height == 180
        }
        println("init 初始化完成")
    }
    constructor(name: String):this(name,0,0){
        println("第一个次构造函数")
    }
    constructor(name: String,age: Int):this(name){
        println("第二个次构造函数")
    }
}

fun fooFlag(){
    arrayOf(2,3,4,5,6).forEach lit@ {
        if (it == 3){
            return@lit
        }

    }
    println("到底执行了哪一个lit")
    arrayOf(2,3,4,5,6).forEach {
        if (it == 3){
            return
        }
    }
    println("到底执行了哪一个")

}



fun studyWhile(){
    var arrayOf = arrayOf(2,32,33,44,55,66,77)
    for (i :Int in arrayOf){
        println("element is $i")
    }

    for(i: Int in arrayOf.indices){
        println("indices element is ${arrayOf[i]}")
    }
    println("另外一种使用方法")
    for (i in 1..10){
        println("for in is $i")
    }

    for ((index,value) in arrayOf.withIndex()){
        println("element $index is $value")
    }
    //标签的使用
    ongloop@for (i:Int in arrayOf){
        for (j:Int in arrayOf){
            if (j == 32){
                break@ongloop
            }
        }
    }


}



fun useWhen(){
    val me = "9"
    val m = when(me){
        "1" -> "this is dog"
        "2" -> "hah"
        else -> "zijie"
    }
    val l = 10
    when(l){
        in 1..100 -> 100
        is Int -> 300
        else -> 200
    }
}

fun rangeTest(){
    println("-0.0和0.0谁大 ${-0.0 < 0.0}")
    var c: Char = 'a';
    var str: String = "\n hezijie"
    println(c.toInt())
    if ('a' in '0'..'9'){

    }
    var arrayOf = arrayOf("he", "zijie", "tim")
    arrayOf.forEach { println(it) }
    Array(5,{i-> (i * i).toString()})
    var arrayOfNulls = arrayOfNulls<Int>(10)
    var intArrayOf: IntArray = intArrayOf(1, 2, 3, 4)
    var a: UByte = 1u
    var b = 10u
    val m = 100UL

    val str1 = "hezijie"
    println("str1 3th char is ${str1[2]}")
    for (i in str1){
        println("for test $i")
    }
    val str2 = "hello world\n"
    val str3 = """he
                  | zijie
                  |is
                  |niuban
    """.trimMargin()
    println(str2 + str3)
    val a7 = 1
    val a8 = 2
    var a9 = if (a7 > a8){
        var m = 10
        m
    }else{
        val l = 99
        a8
    }
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