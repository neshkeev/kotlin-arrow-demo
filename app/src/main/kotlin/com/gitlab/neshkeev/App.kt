package com.gitlab.neshkeev

import arrow.Kind
import arrow.core.None
import arrow.core.Option
import arrow.core.Some
import arrow.core.extensions.option.monad.binding
import arrow.core.fix
import arrow.extension
import arrow.higherkind
import arrow.typeclasses.Functor
import com.gitlab.neshkeev.parserk.functor.map

/*
COPIED FROM GENERATED SOURCES
 */
//class ForParserK private constructor() { companion object }
//typealias ParserKOf<A> = arrow.Kind<ForParserK, A>
//typealias ParserKKindedJ<A> = io.kindedj.Hk<ForParserK, A>
//
//@Suppress("UNCHECKED_CAST", "NOTHING_TO_INLINE")
//inline fun <A> ParserKOf<A>.fix(): ParserK<A> = this as ParserK<A>

data class Result<A>(val res: A, val r: String) {
    companion object
}

@higherkind
data class ParserK<A>(val f: (String) -> Option<Result<A>>): ParserKOf<A> {
    companion object
}

@extension
interface ParserKFunctor : Functor<ForParserK> {
    override fun <A, B> Kind<ForParserK, A>.map(f: (A) -> B): Kind<ForParserK, B> {
        val (first) = this.fix()
        val second : (String) -> Option<Result<B>> = {
            s -> binding {
                val (a) = first(s)
                val (res, rest) = a
                Result(f(res), rest)
            }
        }

        return ParserK(second)
    }

    companion object
}

fun main() {
//    val f: (String) -> Option<Result<String>> = { s -> Some(Result("Hello", s)) }
//    val a = ParserK(f)
//    val fix = a.map { it.length }.fix()
//    println(fix.f("I am fine"))
}
