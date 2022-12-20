import { CreateAgenceComponent } from './modules/agence/create-agence/create-agence.component';
import { UpdateAgenceComponent } from './modules/agence/update-agence/update-agence.component';
import { DetailsAgenceComponent } from './modules/agence/details-agence/details-agence.component';
import { AllAgenceComponent } from './modules/agence/all-agence/all-agence.component';
import { AdminLayoutComponent } from './admin-layout/admin-layout.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ListApporteurComponent } from './apporteur/list-apporteur/list-apporteur.component';
import { CreateEmployeeComponent } from './modules/employee/create-employee/create-employee.component';
import { AllEmployeeComponent } from './modules/employee/all-employee/all-employee.component';

const routes: Routes = [
  // {path: 'home', component: HomeComponent},
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  // {path: '**', redirectTo: 'home', pathMatch: 'full'},

  {
    path: '',
    component: AdminLayoutComponent,
    children: [
      {path: 'home', component: HomeComponent},
      {path: 'apporteurs', component: ListApporteurComponent},

       
      {path: 'agence', component: AllAgenceComponent},
      {path: 'agence/detail/:id', component: DetailsAgenceComponent},
      {path: 'agence/edit/:id', component: UpdateAgenceComponent},
      {path: 'agence/new', component: CreateAgenceComponent},

      {path: 'employee', component: AllEmployeeComponent},
      {path: 'employee/new', component: CreateEmployeeComponent},

      {path: 'agences', component : AllAgenceComponent},
      {path: 'agences/:id/details', component: DetailsAgenceComponent},
      {path: 'agences/:id/edit', component: UpdateAgenceComponent},
      {path: 'agences/new', component: CreateAgenceComponent, pathMatch: 'full'},

    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
