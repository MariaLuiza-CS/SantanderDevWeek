package com.example.santanderdevweek.data.datalocal

import com.example.santanderdevweek.data.Account
import com.example.santanderdevweek.data.Card
import com.example.santanderdevweek.data.Client

class FakeData {
    fun getLocalData(): Account {

        val client = Client("Eduarda")
        val card = Card("0099")

        return Account(
            "012345-0",
            "0123",
            "R$ 2.450,80",
            "R$ 4.000,00",
            client,
            card
        );

    }

}