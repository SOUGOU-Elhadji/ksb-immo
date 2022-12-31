import { CreateProprieteComponent } from './modules/propriete/create-propriete/create-propriete.component';
import { AllProprietaireComponent } from './modules/proprietaire/all-proprietaire/all-proprietaire.component';
import { LoyerNonPayesComponent } from './modules/loyer/loyer-non-payes/loyer-non-payes.component';
import { LoyerPayesComponent } from './modules/loyer/loyer-payes/loyer-payes.component';
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
import { CreateLocataireComponent } from './modules/locataire/create-locataire/create-locataire.component';
import { UpdateProprietaireComponent } from './modules/proprietaire/update-proprietaire/update-proprietaire.component';
import { CreateProprietaireComponent } from './modules/proprietaire/create-proprietaire/create-proprietaire.component';
import { DetailsProprieteComponent } from './modules/propriete/details-propriete/details-propriete.component';
import { UpdateProprieteComponent } from './modules/propriete/update-propriete/update-propriete.component';

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
      //Employee Routes
      {path: 'employes', component: AllEmployeeComponent},
      {path: 'employes/new', component: CreateEmployeeComponent},
      //Agence Routes
      {path: 'agences', component : AllAgenceComponent},
      {path: 'agences/:id/details', component: DetailsAgenceComponent},
      {path: 'agences/:id/edit', component: UpdateAgenceComponent},
      {path: 'agences/new', component: CreateAgenceComponent, pathMatch: 'full'},
      //Locataire Routes
      {path: 'locataires/new', component: CreateLocataireComponent},
      //Loyer Routes
      {path: 'loyers/payes', component: LoyerPayesComponent},
      {path: 'loyers/non-payes', component: LoyerNonPayesComponent},

      //Proprietaire Routes
      {path: 'proprietaires', component: AllProprietaireComponent},
      {path: 'proprietaires/new', component: CreateProprietaireComponent},
      {path: 'proprietaires/:id/new-propriete', component: CreateProprieteComponent},
      {path: 'proprietaires/:id/edit', component: UpdateProprietaireComponent},

      //Proprietes Routes
      {path: 'proprietes/:id/details', component: DetailsProprieteComponent},
      {path: 'proprietes/:id/edit', component: UpdateProprieteComponent},
      // {path: 'proprietes/rent', component: ProprieteLoueesComponent},
      // {path:'proprietes/free', component: ProprieteDisponiblesComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
