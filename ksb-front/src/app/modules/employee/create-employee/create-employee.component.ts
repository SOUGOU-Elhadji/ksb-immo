import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Agence } from 'src/app/shared/models/agence';
import { Employee } from 'src/app/shared/models/employee';
import { AgenceService } from 'src/app/shared/services/agence.service';
import { EmployeeService } from 'src/app/shared/services/employee.service';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {

  employee: Employee = new Employee();
  agences: Agence[] = [];

  @Input() inputFormGroup = this.fb.group({});



  constructor(private fb: FormBuilder, private employeeService: EmployeeService, private agenceService: AgenceService) { }

  ngOnInit(): void {
    this.agenceService.getAllAgences().subscribe((response) => {
      this.agences = response;
      console.log(response);
    })
  }

  public onSubmit(){
    try{
      this.employeeService.createEmployee(this.employee).subscribe(data => {
        console.log(data);
      //  this.reload();
      });
    }catch(error){
      throw error;
    }
  }

}
