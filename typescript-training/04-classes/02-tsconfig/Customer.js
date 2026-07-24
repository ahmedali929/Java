"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
class Customer {
    _firstName;
    _lastName;
    constructor(firstName, lastName) {
        this._firstName = firstName;
        this._lastName = lastName;
    }
    get firstName() {
        return this._firstName;
    }
    set firstName(value) {
        this._firstName = value;
    }
    get lastName() {
        return this._lastName;
    }
    set lastName(value) {
        this._lastName = value;
    }
}
let myCustomer = new Customer("Taha", "Shah");
myCustomer.firstName = "Ahmed";
myCustomer.lastName = "Ali";
console.log(myCustomer.firstName);
console.log(myCustomer.lastName);
//# sourceMappingURL=Customer.js.map