"use strict";
class Customer {
    firstName;
    lastName;
    constructor(theFirst, theLast) {
        this.firstName = theFirst;
        this.lastName = theLast;
    }
    getFirstName() {
        return this.firstName;
    }
    getLastName() {
        return this.lastName;
    }
    setFirstName(theFirst) {
        this.firstName = theFirst;
    }
    setLastName(theLast) {
        this.lastName = theLast;
    }
}
let myCustomer = new Customer("Taha", "Shah");
console.log(myCustomer.firstName);
console.log(myCustomer.lastName);
