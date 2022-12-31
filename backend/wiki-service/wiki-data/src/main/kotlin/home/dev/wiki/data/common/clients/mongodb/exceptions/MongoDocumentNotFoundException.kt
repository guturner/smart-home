package home.dev.wiki.data.common.clients.mongodb.exceptions

class MongoDocumentNotFoundException(
        override val message: String): Exception(message)