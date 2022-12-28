import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/app/shared/models/employee';
import { EmployeeService } from 'src/app/shared/services/employee.service';

@Component({
  selector: 'app-all-employee',
  templateUrl: './all-employee.component.html',
  styleUrls: ['./all-employee.component.css']
})
export class AllEmployeeComponent implements OnInit {

  employ: Employee[]=[];

  constructor(private serviceEmployee: EmployeeService ) { }

  ngOnInit(): void {
    this.getAllEmployee()


  }



public getAllEmployee(){
  return this.serviceEmployee.getAllEmployee().subscribe((response) =>{
    this.employ = response;
    console.log(response);
  })
}


public deleteEmployee(id: string){
  return this.serviceEmployee.deleteEmployee(id).subscribe(data =>{
    console.log(data);
    window.location.reload();
  })
}



}
