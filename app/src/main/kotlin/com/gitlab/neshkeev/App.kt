package com.gitlab.neshkeev

import arrow.core.None
import arrow.core.Option
import arrow.core.Some
import arrow.higherkind
import com.gitlab.neshkeev.extension.parserk.functor.map

/*
COPIED FROM GENERATED SOURCES
 */
//class ForParserK private constructor() { companion object }
//typealias ParserKOf<A> = arrow.Kind<ForParserK, A>
//typealias ParserKKindedJ<A> = io.kindedj.Hk<ForParserK, A>
//
//@Suppress("UNCHECKED_CAST", "NOTHING_TO_INLINE")
//inline fun <A> ParserKOf<A>.fix(): ParserK<A> = this as ParserK<A>
//
//data class Result<A>(val res: A, val r: String) {
//    companion object
//}

@higherkind
data class ParserK<A>(val f: (String) -> Option<Result<A>>): ParserKOf<A> {
    companion object
}

fun anyChr() : ParserK<String> = ParserK { s ->
    if (s.isEmpty()) None
    else Some(Result(s[0].toString(), s.substring(1)))
}

fun main() {
    println(anyChr().f("ABC"))
    println(anyChr().f(""))
    println(anyChr().map { it.toInt() }.f("1AB"))
}
