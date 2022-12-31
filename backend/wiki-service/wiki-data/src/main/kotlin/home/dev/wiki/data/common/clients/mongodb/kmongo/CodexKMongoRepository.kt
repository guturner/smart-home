package home.dev.wiki.data.common.clients.mongodb.kmongo

import com.mongodb.client.MongoCollection
import home.dev.wiki.data.common.clients.mongodb.CodexMongoRepository
import home.dev.wiki.data.common.clients.mongodb.exceptions.MongoDeleteException
import home.dev.wiki.data.common.clients.mongodb.exceptions.MongoReadException
import home.dev.wiki.data.common.clients.mongodb.exceptions.MongoSaveException
import home.dev.wiki.data.common.clients.mongodb.exceptions.MongoUpdateException
import home.dev.wiki.data.common.models.CodexMongoModel
import org.bson.Document
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.updateOne

abstract class CodexKMongoRepository<T: CodexMongoModel>: CodexMongoRepository<T> {

    abstract var collection: MongoCollection<T>

    override fun getById(id: String): T? {
        return try {
            collection.findOne(CodexMongoModel::id eq id)
        } catch(t: Throwable) {
            throw MongoReadException("Failed to read from the database.")
        }
    }

    override fun getAll(): Sequence<T> {
        return try {
            val result = collection.find()
            result.asIterable().map { it }.asSequence()
        } catch(t: Throwable) {
            throw MongoReadException("Failed to read from the database.")
        }
    }

    override fun save(document: T): T {
        return try {
            collection.insertOne(document)
            document
        } catch(t: Throwable) {
            throw MongoSaveException("Failed to save document: $document to database.")
        }
    }

    override fun saveAll(documents: Sequence<T>): Sequence<T> {
        return try {
            collection.insertMany(documents.toList())
            documents
        } catch(t: Throwable) {
            throw MongoSaveException("Failed to save documents: $documents to database.")
        }
    }

    override fun update(document: T): T {
        return try {
            collection.updateOne(
                    CodexMongoModel::id eq document.id,
                    document
            )

            collection.findOne(CodexMongoModel::id eq document.id)
                    ?: throw MongoUpdateException("Failed to update document: $document.")
        } catch(t: Throwable) {
            throw MongoUpdateException("Failed to update document: $document.")
        }
    }

    override fun deleteById(id: String): Boolean {
        return try {
            collection.findOneAndDelete(CodexMongoModel::id eq id)
                    ?: throw MongoDeleteException("Failed to delete document associated with id: $id.")

            true
        } catch (t: Throwable) {
            throw MongoDeleteException("Failed to delete document associated with id: $id.")
        }
    }

    override fun deleteAll(): Boolean {
        return try {
            collection.deleteMany(Document())
                    ?: throw MongoDeleteException("Failed to delete all documents.")

            true
        } catch (t: Throwable) {
            throw MongoDeleteException("Failed to delete all documents.")
        }
    }
}