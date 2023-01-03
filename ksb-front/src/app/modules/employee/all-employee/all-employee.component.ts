import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Employee } from 'src/app/shared/models/employee';
import { EmployeeService } from 'src/app/shared/services/employee.service';

@Component({
  selector: 'app-all-employee',
  templateUrl: './all-employee.component.html',
  styleUrls: ['./all-employee.component.css']
})
export class AllEmployeeComponent implements OnInit {

  employ: Employee[] = [];
  p: number = 1;
  matricule!: string;

  constructor(private serviceEmployee: EmployeeService,
    private toastr: ToastrService,
    private route: Router) { }

  ngOnInit(): void {
    this.getAllEmployee()


  }



  public getAllEmployee() {
    return this.serviceEmployee.getAllEmployee().subscribe((response) => {
      this.employ = response;
      console.log(response);
    })
  }



  public deleteEmployee(employee: Employee) {
    return this.serviceEmployee.deleteEmployee(employee.matricule).subscribe((response) => {
      try {
        this.getAllEmployee();
        this.showSuccess();
      } catch (error) {
        throw error;
      }
    })
  }

  public showSuccess() {
    this.toastr.success('Employee supprimé avec succès', 'Success', {
      timeOut: 5000,
      progressBar: true,
      progressAnimation: 'increasing',
      positionClass: 'toast-bottom-right'
    });
  }

  public showError() {
    this.toastr.error('Erreur lors de la suppression de l\'employer', 'Error', {
      timeOut: 5000,
      progressBar: true,
      progressAnimation: 'increasing',
      positionClass: 'toast-bottom-right'
    });
  }

  employerDetails(matricule: string){
    this.route.navigate(['employes', matricule, 'details']);
  }


}
