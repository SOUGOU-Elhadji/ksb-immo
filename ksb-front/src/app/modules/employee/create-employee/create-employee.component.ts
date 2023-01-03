import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
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

  employ: Employee[] = [];

  // public form!: FormGroup;


  // @Input() inputFormGroup = this.fb.group({});



  constructor(private fb: FormBuilder,
    private employeeService: EmployeeService,
    private agenceService: AgenceService,
    private route: Router,
    private toastr: ToastrService,) { }

  ngOnInit(): void {
    this.getAgences();

    this.employeeService.getAllEmployee().subscribe(response => {
      this.employ = response;
    })

  }

  public onSubmit() {
    try {
      this.employeeService.createEmployee(this.employee).subscribe(data => {
        console.log(data);
        this.showSuccess();
        this.route.navigate(['/employes']);
      });
    } catch (error) {
      this.showError();
    }
  }

  public getAgences() {
    this.agenceService.getAllAgences().subscribe((response) => {
      this.agences = response;
      console.log(response);
    })
  }

  public showSuccess() {
    this.toastr.success('Employee enregistré avec succès', 'Success', {
      timeOut: 5000,
      progressBar: true,
      progressAnimation: 'increasing',
      positionClass: 'toast-bottom-right'
    });
  }

  public showError() {
    this.toastr.error('Erreur lors de l\'enregistrement de l\'employer', 'Error', {
      timeOut: 5000,
      progressBar: true,
      progressAnimation: 'increasing',
      positionClass: 'toast-bottom-right'
    });
  }


}
