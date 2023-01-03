import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeDto } from 'src/app/shared/dts/employee-dto';
import { Employee } from 'src/app/shared/models/employee';
import { EmployeeService } from 'src/app/shared/services/employee.service';

@Component({
  selector: 'app-details-employee',
  templateUrl: './details-employee.component.html',
  styleUrls: ['./details-employee.component.css']
})
export class DetailsEmployeeComponent implements OnInit {
  
  matricule!: string;
  id!: string;
  employe: EmployeeDto = new EmployeeDto();
  date: Date = new Date();

  constructor(private service: EmployeeService, 
    private activedRoute: ActivatedRoute,
    private route: Router) { }

  ngOnInit(): void {
    this.matricule = this.activedRoute.snapshot.params['matricule'];
    this.service.getEmployeeByMatricule(this.matricule).subscribe(data => {
      this.employe = data;
    });
  }

  employerDetails(matricule: string){
    this.route.navigate(['employes', matricule, 'edit']);
  }

}
