package com.example.composeexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.composeexample.model.Message

class ListViewModel: ViewModel() {
    
    private val _messages: MutableLiveData<List<Message>> = MutableLiveData(emptyList())
    
    val messages: LiveData<List<Message>> = _messages
    
    fun addNewMessage() {
        _messages.value = _messages.value?.toMutableList().apply { 
            this?.add(getNewMessage())
        }
    }

    private fun getNewMessage(): Message {
        return Message(
            author = getRandomAuthor(),
            message = getRamdomMessage()
        )
    }

    private fun getRandomAuthor(): String {
        return listOf(
            "Leandro","Sampaio", "Kujava", "Richard", "Leandro 2", "Sampaio 2 ", "Kujava 2", "Alguem "
        ).random()
    }

    private fun getRamdomMessage(): String {
       return listOf(
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
             "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old.",
             "Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. ",
             "Message Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, Lorem ipsum dolor sit amet.., comes from a line in section 1.10.32.",
             "Message Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, Lorem ipsum dolor sit amet.., comes from a line in section 1.10.32.",
            "Message Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, Lorem ipsum dolor sit amet.., comes from a line in section 1.10.32.",
            "Message Message Message Message Message Message Message"
        ).random()
    }
}