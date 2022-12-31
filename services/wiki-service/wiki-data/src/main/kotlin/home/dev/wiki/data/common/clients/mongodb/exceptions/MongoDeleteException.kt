package home.dev.wiki.data.common.clients.mongodb.exceptions

class MongoDeleteException(
        override val message: String): Exception(message)