import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EmployeeRoutingModule } from './employee-routing.module';
import { DetailsEmployeeComponent } from './details-employee/details-employee.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';
import { AllEmployeeComponent } from './all-employee/all-employee.component';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    DetailsEmployeeComponent,
    UpdateEmployeeComponent,
    AllEmployeeComponent,
    CreateEmployeeComponent
  ],
  imports: [
    CommonModule,
    EmployeeRoutingModule,
    FormsModule
  ],
  exports: [
    DetailsEmployeeComponent,
    UpdateEmployeeComponent,
    AllEmployeeComponent,
    CreateEmployeeComponent
  ]
})
export class EmployeeModule { }
