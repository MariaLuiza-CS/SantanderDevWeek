package com.example.santanderdevweek.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.santanderdevweek.R
import com.example.santanderdevweek.data.Account

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        findAccountClient()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.menu_notification, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item03 -> {
                Log.d("CLICK", "click item 02")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun findAccountClient() {
        mainViewModel.buscarContaCliente().observe(this, Observer { result ->
            bindOnView(result)
        })
    }

    private fun bindOnView(account: Account) {
        findViewById<TextView>(R.id.txt_user).text = account.client.name
        findViewById<TextView>(R.id.txt_cartao_number).text = account.card.numberCard
        findViewById<TextView>(R.id.txt_agency).text = "Ag ${account.agency}"
        findViewById<TextView>(R.id.txt_number).text = "Cc ${account.number}"
        findViewById<TextView>(R.id.txt_balance).text = account.balance
        findViewById<TextView>(R.id.txt_limite).text = account.limite
    }
}