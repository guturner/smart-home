package home.dev.wiki.data.common.clients.mongodb.exceptions

class MongoUpdateException(
        override val message: String): Exception(message)