package home.dev.wiki.domain.common.testutils

import com.github.javafaker.Faker
import java.util.*

fun getDummyUUID(): String {
    return UUID.randomUUID().toString()
}

fun getDummySentence(numberOfWords: Int = 6): String {
    return Faker().lorem().sentence(numberOfWords)
}