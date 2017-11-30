package net.println.kt07

/**
 * @Author: Kevin
 * @Description:
 * @Date: Created in 22:09 2017/11/30
 * @Modified By:
 */

import io.reactivex.Observable
import io.reactivex.functions.Consumer
import java.io.File

fun main(args: Array<String>) {
//    val text = "hhh   x  a"
    val text = File(ClassLoader.getSystemResource("input").path).readText();

    Observable
            .fromIterable(text.toCharArray().asIterable())
            .filter { !it.isWhitespace() } // 当Java函数的形参是个接口且只有一个抽象方法可以用lambda代替
            .groupBy { it }
            .subscribe {
                o ->
                o.count().subscribe(Consumer {  // 这里的subscribe（）有重载
                    println("${o.key} -> $it")
                })
            }
}