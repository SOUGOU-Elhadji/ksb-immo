import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AgenceRoutingModule } from './agence-routing.module';
import { AllAgenceComponent } from './all-agence/all-agence.component';
import { CreateAgenceComponent } from './create-agence/create-agence.component';
import { UpdateAgenceComponent } from './update-agence/update-agence.component';
import { DetailsAgenceComponent } from './details-agence/details-agence.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AllAgenceComponent,
    CreateAgenceComponent,
    UpdateAgenceComponent,
    DetailsAgenceComponent
  ],
  imports: [
    CommonModule,
    AgenceRoutingModule,
    FormsModule
  ],
  exports: [
    AllAgenceComponent,
    CreateAgenceComponent,
    UpdateAgenceComponent,
    DetailsAgenceComponent
  ]
})
export class AgenceModule { }
