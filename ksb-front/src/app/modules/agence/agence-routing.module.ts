import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminLayoutComponent } from 'src/app/admin-layout/admin-layout.component';
import { AllAgenceComponent } from './all-agence/all-agence.component';
import { CreateAgenceComponent } from './create-agence/create-agence.component';
import { DetailsAgenceComponent } from './details-agence/details-agence.component';
import { UpdateAgenceComponent } from './update-agence/update-agence.component';

const routes: Routes = [
<<<<<<< HEAD
 
  // {path: 'agence', component: AllAgenceComponent},
  // {path: 'detail/:id', component: DetailsAgenceComponent},
  // {path: 'edit/:id', component: UpdateAgenceComponent},
  // {path: 'new', component: CreateAgenceComponent},
   
 
=======
>>>>>>> 8aa6e20aa801b95daf4f4cdf0657bf6d26d71177
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AgenceRoutingModule { }
