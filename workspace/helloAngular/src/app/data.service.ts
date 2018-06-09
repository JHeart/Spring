import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';
 
import { Customer } from './customer';

@Injectable({
  providedIn: 'root'
})  
export class DataService {

  private baseUrl = 'api/customers';  // URL to web API
  private headers = new Headers({'Content-Type': 'application/json'});
 
  constructor(private http: Http) {}
 
  // Get all customers
  getCustomers(): Promise<Customer[]> {

    return this.http.get(this.baseUrl)
      .toPromise()
      .then(response => response.json() as Customer[])
      .catch(this.handleError);
  }
 
  getCustomersByLastName(lastName: string): Promise<Customer[]> {
    const url= `${this.baseUrl}/${lastName}`;

    return this.http.get(url)
      .toPromise()
      .then(response => response.json() as Customer[])
      .catch(this.handleError);
  }
  
  create(customer: Customer): Promise<Customer> {
   
    return this.http
      .post(this.baseUrl, JSON.stringify(customer), {headers : this.headers})
      .toPromise()
      .then(() => null)
      .catch(this.handleError);
  }
 
  delete(id: number): Promise<void> {
   const url= `${this.baseUrl}/${id}`;

    return this.http.delete(url)
      .toPromise()
      .then(() => null)
      .catch(this.handleError);
  }
 
  private handleError(error: any): Promise<any> {
    console.error('Error:', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }
}