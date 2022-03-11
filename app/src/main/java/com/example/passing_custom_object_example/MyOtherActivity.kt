package com.example.passing_custom_object_example

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.passing_custom_object_example.databinding.MyOtherActivityBinding

class MyOtherActivity : AppCompatActivity() {
    private lateinit var binding: MyOtherActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MyOtherActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val newPerson = intent.getParcelableExtra<Person>(Constants.SELECTED_PERSON_KEY.name)

        if (newPerson != null) {
            System.out.println(newPerson)
            displayName(newPerson.firstName, newPerson.surname, newPerson.address)
        }
    }
    @SuppressLint("SetTextI18n")
    private fun displayName(firstName: String?, surname: String?, address: Address?){
        binding.outputNameTextView.text = "$firstName $surname \n" +
                " ${address!!.houseNameNumber} \n" +
                "${address.street} \n" +
                "${address.town}\n " +
                address.postcode
    }
    fun returnToActivityOne(view: View){
        finish()
    }
}