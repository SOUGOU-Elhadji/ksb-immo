import { CreateAgenceComponent } from './modules/agence/create-agence/create-agence.component';
import { UpdateAgenceComponent } from './modules/agence/update-agence/update-agence.component';
import { DetailsAgenceComponent } from './modules/agence/details-agence/details-agence.component';
import { AllAgenceComponent } from './modules/agence/all-agence/all-agence.component';
import { AdminLayoutComponent } from './admin-layout/admin-layout.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ListApporteurComponent } from './apporteur/list-apporteur/list-apporteur.component';

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
