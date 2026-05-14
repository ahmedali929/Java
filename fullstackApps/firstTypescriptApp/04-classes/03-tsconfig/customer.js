"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
class Customer {
    _firstName;
    _lastName;
    constructor(theFirst, theLast) {
        this._firstName = theFirst;
        this._lastName = theLast;
    }
    get firstName() {
        return this._firstName;
    }
    get lastName() {
        return this._lastName;
    }
    set lirstName(theFirst) {
        this._firstName = theFirst;
    }
    set lastName(theLast) {
        this._lastName = theLast;
    }
}
let myCustomer = new Customer("Taha", "Shah");
console.log(myCustomer.firstName);
console.log(myCustomer.lastName);
//# sourceMappingURL=customer.js.map