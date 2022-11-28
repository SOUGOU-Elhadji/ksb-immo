import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProprieteRoutingModule } from './propriete-routing.module';
import { AllProprieteComponent } from './all-propriete/all-propriete.component';
import { CreateProprieteComponent } from './create-propriete/create-propriete.component';
import { UpdateProprieteComponent } from './update-propriete/update-propriete.component';
import { DetailsProprieteComponent } from './details-propriete/details-propriete.component';


@NgModule({
  declarations: [
    AllProprieteComponent,
    CreateProprieteComponent,
    UpdateProprieteComponent,
    DetailsProprieteComponent
  ],
  imports: [
    CommonModule,
    ProprieteRoutingModule
  ],
  exports: [
    AllProprieteComponent,
    CreateProprieteComponent,
    UpdateProprieteComponent,
    DetailsProprieteComponent
  ]
})
export class ProprieteModule { }
