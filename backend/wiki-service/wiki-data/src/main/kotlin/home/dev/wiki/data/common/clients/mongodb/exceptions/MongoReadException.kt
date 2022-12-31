package home.dev.wiki.data.common.clients.mongodb.exceptions

class MongoReadException(
        override val message: String): Exception(message)