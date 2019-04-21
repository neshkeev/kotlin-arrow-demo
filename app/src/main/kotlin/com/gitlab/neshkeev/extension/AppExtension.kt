package com.gitlab.neshkeev.extension

import arrow.Kind
import arrow.core.Option
import arrow.core.extensions.option.monad.binding
import arrow.extension
import arrow.typeclasses.Functor
import com.gitlab.neshkeev.ForParserK
import com.gitlab.neshkeev.ParserK
import com.gitlab.neshkeev.fix
import com.gitlab.neshkeev.Result

@extension
interface ParserKFunctor : Functor<ForParserK> {
    override fun <A, B> Kind<ForParserK, A>.map(f: (A) -> B): Kind<ForParserK, B> {
        val (first) = this.fix()
        val second : (String) -> Option<Result<B>> = { s ->
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

