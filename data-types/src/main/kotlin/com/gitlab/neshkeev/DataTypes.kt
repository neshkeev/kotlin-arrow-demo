package com.gitlab.neshkeev

import arrow.core.Either
import arrow.higherkind

data class Result<A>(val res: A, val r: String) {
    companion object
}

@higherkind
data class ParserK<A>(val f: (String) -> Either<String, Result<A>>): ParserKOf<A> {
    companion object
}
