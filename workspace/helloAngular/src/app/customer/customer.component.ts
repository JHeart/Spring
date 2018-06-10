import { Component, OnInit } from '@angular/core';

import { Customer } from '../customer';
import { DataService } from '../data.service';

@Component({
  selector: 'app-customer',//name
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {//class=logic
//외부에서 사용이 가능하도록 export
  customers: Customer[];// 변수 : 타입
  selectedCustomer: Customer;

  constructor(private dataService: DataService) {}
 
  getCustomers() {
     this.dataService.getCustomers().then(customers => this.customers = customers);
  }
 
  ngOnInit(): void {
     this.getCustomers();
  }
 
  onSelect(cust: Customer): void {
    this.selectedCustomer = cust;
  }
}