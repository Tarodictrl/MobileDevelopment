package com.example.lab2.domain

open class Manager(empId: Int, name: String, ssn: String, salary: Double, deptName: String) :
    Employee(empId, name, ssn, salary) {
    var deptName : String? = deptName
        private set
}