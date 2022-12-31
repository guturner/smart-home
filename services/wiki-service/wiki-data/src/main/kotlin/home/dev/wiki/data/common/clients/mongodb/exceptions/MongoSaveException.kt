package home.dev.wiki.data.common.clients.mongodb.exceptions

class MongoSaveException(
        override val message: String): Exception(message)