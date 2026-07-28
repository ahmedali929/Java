import { Component, OnInit } from '@angular/core';
import { SalesPerson } from './sales-person';

@Component({
  selector: 'app-sales-person-list',
  templateUrl: './sales-person-list.component.html',
  styleUrls: ['./sales-person-list.component.css']
})
export class SalesPersonListComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  // create an array of objects
  salesPersonList: SalesPerson[] = [
    new SalesPerson("Taha", "Shah", "taha.shah@test.com", 50000),
    new SalesPerson("Ahmed", "Ali", "ahmed.ali@test.com", 40000),
    new SalesPerson("Hassan", "Zaidi", "hassan.zaidi@test.com", 30000)
  ]


}
