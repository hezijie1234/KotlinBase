package com.zijie.kotlinbase.objectandclass

/**
 * Created by hezijie on 2019/12/18.
 */
class Person (val name:String = "zijie", val age:Int = 18) {
    private var heght:Int;
    private var force:String;
    var n = name;
    //init中使用的属性必须在它之前声明
    init {
        println("到底哪一个参数是正确的参数 ${name + age}")
        heght = 0;
        force = "zijie";
        var m = name;
    }

    constructor( name: String):this(name,1){

    }

}
fun  main(){
    val student:Student = Student("hezijie")
    //如果主构造器所有的值都制定了默认值，编译器将会产生一个无参构造器
    var person: Person = Person("项羽");

}

/**
 * 如果非抽象类没有声明任何构造器，将会默认有一个无参public的构造器
 * 初始化方法是在主构造器执行里面执行的，而主构造器是在次级构造器的第一行执行的，所以初始化部门最先调用
 */
class Student{
    init {
        println("初始化函数执行了")
    }
    public constructor(name:String){
        println("次级构造器执行了！$name")
    }
}