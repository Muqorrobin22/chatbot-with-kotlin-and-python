package com.example.chatbot_app_pa.utils

object BotResponse {
    fun basicResponses(_message: String) : String {

        val random = (0..2).random()
        val message = _message.lowercase()

        // The Bot Response
        return when {

            message.contains("hello") -> {
                when (random) {
                    0 -> "Hello gann! Selamat Datang di Smart Consult"
                    1 -> "Yuhuuu It's me, The Bot From Smart Consult"
                    2 -> "Yap. Are You Calling ME ? \nHOW DARE YOU! \nOh.. I apologize, Just Kidding :D"
                    else -> "Can I Help YOU?.. "
                }
            }

            message.contains("how are you") -> {
                when (random) {
                    0 -> "Oh.. this is the first time I have been questioned like this "
                    1 -> "I'm Doing Great"
                    2 -> "Wew.. So Cute :D"
                    else -> "Yuhuu. I'm Fine"
                }
            }

            else -> {
                when (random) {
                    0 -> "Sorry.. I Wish I Understand that :("
                    1 -> "Sorry Dear. I Don't Understand What You meant"
                    2 -> "Noo.. Please repeat that again ?"
                    else -> "Sorry I don't Understand :("
                }
            }

        }

    }
}