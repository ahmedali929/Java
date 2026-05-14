class Customer {
    _firstName: string;
    _lastName: string;

    constructor(theFirst: string, theLast: string) {
        this._firstName = theFirst;
        this._lastName = theLast;
    }

    get firstName(): string {
        return this._firstName;
    }

    set firstName(value: string) {
        this._firstName = value;
    }

    get lastName(): string {
        return this.lastName;
    }

    set lastName(value: string) {
        this.lastName = value;
    }
   
}

let myCustomer = new Customer("Taha", "Shah");


console.log(myCustomer.firstName);
console.log(myCustomer.lastName);
