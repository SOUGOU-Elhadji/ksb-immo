import { NgxPaginationModule } from 'ngx-pagination';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProprieteRoutingModule } from './propriete-routing.module';
import { AllProprieteComponent } from './all-propriete/all-propriete.component';
import { CreateProprieteComponent } from './create-propriete/create-propriete.component';
import { UpdateProprieteComponent } from './update-propriete/update-propriete.component';
import { DetailsProprieteComponent } from './details-propriete/details-propriete.component';
import { ProprieteLoueesComponent } from './propriete-louees/propriete-louees.component';
import { ProprieteDisponiblesComponent } from './propriete-disponibles/propriete-disponibles.component';


@NgModule({
  declarations: [
    AllProprieteComponent,
    CreateProprieteComponent,
    UpdateProprieteComponent,
    DetailsProprieteComponent,
    ProprieteLoueesComponent,
    ProprieteDisponiblesComponent,
  ],
  imports: [
    CommonModule,
    ProprieteRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    NgxPaginationModule,
  ],
  exports: [
    AllProprieteComponent,
    CreateProprieteComponent,
    UpdateProprieteComponent,
    ProprieteLoueesComponent,
    ProprieteDisponiblesComponent,
    DetailsProprieteComponent
  ]
})
export class ProprieteModule { }
