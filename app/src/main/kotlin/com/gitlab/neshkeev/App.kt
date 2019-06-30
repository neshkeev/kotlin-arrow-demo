package com.gitlab.neshkeev

import arrow.Kind
import arrow.core.*
import arrow.extension
import arrow.typeclasses.Functor
import arrow.core.extensions.either.monad.binding
import com.gitlab.neshkeev.parserk.functor.map

@extension
interface ParserKFunctor : Functor<ForParserK> {
    override fun <A, B> Kind<ForParserK, A>.map(f: (A) -> B): Kind<ForParserK, B> {
        val (first) = this.fix()
        val second : (String) -> Either<String, Result<B>> = { s: String ->
            binding {
                val (a) = first(s)
                val (res, rest) = a
                Result(f(res), rest)
            }
        }

        return ParserK(second)
    }

    companion object
}

fun anyChr() : ParserK<String> = ParserK { s ->
    if (s.isEmpty()) Left("End of input")
    else Right(Result(s[0].toString(), s.substring(1)))
}

fun main() {
    println(anyChr().f("ABC"))
    println(anyChr().f(""))
    println(anyChr().map { it.toInt() }.f("1AB"))
}
