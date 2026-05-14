"use strict";
class Customer {
    firstName;
    lastName;
    constructor(theFirst, theLast) {
        this.firstName = theFirst;
        this.lastName = theLast;
    }
}
let myCustomer = new Customer("Taha", "Shah");
console.log(myCustomer.firstName);
console.log(myCustomer.lastName);
