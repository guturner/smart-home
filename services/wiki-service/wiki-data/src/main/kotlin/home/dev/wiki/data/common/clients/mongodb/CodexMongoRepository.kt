package home.dev.wiki.data.common.clients.mongodb

import home.dev.wiki.data.common.models.CodexMongoModel

interface CodexMongoRepository<T: CodexMongoModel> {

    fun getById(id: String): T?
    fun getAll(): Sequence<T>

    fun save(document: T): T
    fun saveAll(documents: Sequence<T>): Sequence<T>

    fun update(document: T): T

    fun deleteById(id: String): Boolean
    fun deleteAll(): Boolean
}