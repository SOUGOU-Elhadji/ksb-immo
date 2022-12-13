import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AgenceDto } from 'src/app/shared/dts/agence-dto';
import { EmployeeDto } from 'src/app/shared/dts/employee-dto';
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

  employee: EmployeeDto = new EmployeeDto();
  agences: Agence[] = [];

employ: Employee[]=[];
  

  @Input() inputFormGroup = this.fb.group({});



  constructor(private fb: FormBuilder, private employeeService: EmployeeService, private agenceService: AgenceService) { }

  ngOnInit(): void {
   this.getAgences();

   this.employeeService.getAllEmployee().subscribe(response => {
    this.employ = response;
   })

  }

  public onSubmit(){
    try{
      this.employeeService.createEmployee(this.employee).subscribe(data => {
        console.log(data);
        // window.location.reload();
      });
    }catch(error){
      throw error;
    }
  }

public getAgences(){
  this.agenceService.getAllAgences().subscribe((response) => {
    this.agences = response;
    console.log(response);
  })
}




}
