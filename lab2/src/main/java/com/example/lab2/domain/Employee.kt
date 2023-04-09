package com.example.lab2.domain

open class Employee {
    var empId = 0
        private set(value){
            if(value > 0)
                field = value
            else
                throw java.lang.Exception("id не может быть меньше нуля!")
        }
    var name: String? = null
        private set
    var ssn: String? = null
        private set
    var salary = 0.0
        private set(value){
            if (value >= 13890)
                field = value
            else
                throw java.lang.Exception("Зарплата ниже МРОТа!")
        }

    fun raiseSalary(increase: Double){
        if (increase > 0)
            this.salary += increase;
    }

    constructor(empId: Int, name: String, ssn: String, salary: Double) {
        this.empId = empId
        this.name = name.uppercase()
        this.ssn = ssn.uppercase()
        this.salary = salary
    }
}