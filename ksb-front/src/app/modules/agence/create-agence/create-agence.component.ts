import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Agence } from 'src/app/shared/models/agence';
import { Employee } from 'src/app/shared/models/employee';
import { AgenceService } from 'src/app/shared/services/agence.service';
import { EmployeeService } from 'src/app/shared/services/employee.service';

@Component({
  selector: 'app-create-agence',
  templateUrl: './create-agence.component.html',
  styleUrls: ['./create-agence.component.css']
})
export class CreateAgenceComponent implements OnInit {

  agence: Agence = new Agence();
  employees: Employee[] = [];

  constructor(private serviceAgence: AgenceService, private router: Router, private serviceEmployee: EmployeeService) { }

  ngOnInit(): void {
    this.serviceEmployee.getAllEmployee().subscribe((response) => {
      this.employees = response;
    })
  }

  public onSubmit(){
    try{
      this.serviceAgence.createAgence(this.agence).subscribe(data => {
        console.log(data);
      //  this.reload();
      });
    }catch(error){
      throw error;
    }
  }
  
  reload(){
    window.location.reload();
  }

}
