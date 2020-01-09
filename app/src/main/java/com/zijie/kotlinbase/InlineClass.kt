package com.zijie.kotlinbase

import androidx.appcompat.app.ActionBarDrawerToggle
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * Created by hezijie on 2020/1/7.
 */
fun main() {
    Deliver(ImplBase()).printYou()
    val e = Example()
    println(e.p)
    e.p = "New"
    println( e.lazyValue)
    println( e.lazyValue)
    val u = User()
    u.name = "first"
    u.name = "second"
}



class User{
    var name:String by Delegates.observable("name init"){
        property, oldValue, newValue -> println("$oldValue->$newValue")
    }
    var age:Int by Delegates.vetoable(1,{
            property, oldValue, newValue ->
        newValue == 10
    })
}

class Delegate{
    operator fun  getValue(thisRef:Any?,property:KProperty<*>):String{
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String){
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }

}

class Example{
    var p:String by Delegate()
    val lazyValue:String by lazy(LazyThreadSafetyMode.NONE) {
        println("computed")
        "hello"
    }
}

interface BaseClass{
    fun printYou();
}

class ImplBase:BaseClass{
    override fun printYou() {
        println("这是实现类ImplBase")
    }

}

class Deliver(val clazz: BaseClass):BaseClass by clazz{
    override fun printYou() {
        println("这个是${javaClass}")
    }
}

inline class UInt(val i:Int){

}

fun  compute(i:Int){

}

fun compute(i:UInt){

}