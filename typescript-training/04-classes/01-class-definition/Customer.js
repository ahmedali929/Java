"use strict";
class Customer {
    firstName;
    lastName;
    constructor(firstName, lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
let myCustomer = new Customer("Taha", "Shah");
console.log(myCustomer.firstName);
console.log(myCustomer.lastName);
