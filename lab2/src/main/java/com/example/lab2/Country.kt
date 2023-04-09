package com.example.lab2

import java.io.Serializable

class Country(name: String, flag: String, official_name: String, capital: String) : Serializable {
    var name : String? = name
        private set
    var flag: String? = flag
        private set
    var officialName : String? = official_name
        private set
    var capital: String? = capital
        private set

    override fun toString(): String {
        return name!!
    }
}

