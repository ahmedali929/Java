class Customer {
    _firstName: string;
    _lastName: string;

    constructor(theFirst: string, theLast: string) {
        this._firstName = theFirst;
        this._lastName = theLast;
    }

    public get firstName(): string {
        return this._firstName;
    }

    public get lastName(): string {
        return this._lastName;
    }

    public set lirstName(theFirst: string) {
        this._firstName = theFirst;
    }

    public set lastName(theLast: string) {
        this._lastName = theLast;
    }
   
}

let myCustomer = new Customer("Taha", "Shah");


console.log(myCustomer.firstName);
console.log(myCustomer.lastName);
