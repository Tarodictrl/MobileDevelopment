package com.example.lab2.domain

fun printEmployee(emp : Employee) {
    println("Employee ID: " + emp.empId);
    println("Employee Name: " + emp.name);
    println("Employee Soc Sec # " + emp.ssn)
    println("Employee salary: " + emp.salary)
    println()
}

fun main() {
    val emp = Employee(101, "Ikar", "012-34-5678", 120_345.27)
    val eng = Engineer(101, "Jane Smith", "012-34-5678", 120_345.27)
    val mgr = Manager(207, "Barbara Johnson", "054-12- 2367", 109_501.36, "US Marketing")
    val adm = Admin(304, "Bill Munroe", "108-23-2367", 75_002.34)
    val dir = Director(12, "Susan Wheeler", "099-45- 2340", 120_567.36, "Global Marketing",  1_000_000.00)
    printEmployee(emp)
    printEmployee(eng)
    printEmployee(eng)
    printEmployee(mgr)
    printEmployee(adm)
    printEmployee(dir)
}