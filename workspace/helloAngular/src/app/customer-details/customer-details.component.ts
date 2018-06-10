import { Component, OnInit, Input } from '@angular/core';

import { Customer } from '../customer';
import { DataService } from '../data.service';

@Component({
  selector: 'app-customer-details',
  templateUrl: './customer-details.component.html',
  styleUrls: ['./customer-details.component.css']
})
export class CustomerDetailsComponent implements OnInit {
 
  //input customer를 부모로 부터 받은것이다.
  @Input() customer: Customer;
 
  constructor(private dataService: DataService) {}
 
  ngOnInit() {
  }

  //delete button을 click를 할경우 eventhandler
  delete(): void {
    this.dataService.delete(this.customer.id).then(() => this.goBack());
  }
 
  private goBack(): void {
    window.location.replace('');
  }

}