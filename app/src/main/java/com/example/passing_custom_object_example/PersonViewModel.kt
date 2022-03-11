package com.example.passing_custom_object_example

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class PersonViewModel : ViewModel(){
    var firstName = ObservableField<String>()
        private set
    var surname = ObservableField<String>()
        private set
    var address = ObservableField<Address>()
        private set
    var houseNameNumber = ObservableField<String>()
        private set
    var street = ObservableField<String>()
        private set
    var town = ObservableField<String>()
        private set
    var postcode = ObservableField<String>()
        private set


    fun getNewPerson(): Person {
        return Person (firstName.get().toString(), surname.get().toString(), getAddress())
    }

    private fun getAddress(): Address {
        System.out.println(houseNameNumber.get().toString())
        return Address (

            houseNameNumber.get().toString(), street.get().toString(),
            town.get().toString(), postcode.get().toString())
    }
}
