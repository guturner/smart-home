package com.codex.data.common.clients.mongodb

import com.mongodb.client.MongoClient
import org.litote.kmongo.KMongo

fun buildMongoClient(
        username: String? = null,
        password: String? = null,
        hostName: String,
        port: Int): MongoClient {

    return if (username != null && password != null) {
        KMongo.createClient("mongodb://$username:$password@$hostName:$port")
    } else {
        KMongo.createClient("mongodb://$hostName:$port")
    }
}