import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AllAgenceComponent } from './all-agence/all-agence.component';
import { CreateAgenceComponent } from './create-agence/create-agence.component';
import { DetailsAgenceComponent } from './details-agence/details-agence.component';
import { UpdateAgenceComponent } from './update-agence/update-agence.component';

const routes: Routes = [
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AgenceRoutingModule { }
