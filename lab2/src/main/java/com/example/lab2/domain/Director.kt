package com.example.lab2.domain

class Director(empId: Int, name: String, ssn: String, salary: Double, deptName: String, budget: Double) :
    Manager(empId, name, ssn, salary, deptName) {
    var budget : Double = budget
        private set
}