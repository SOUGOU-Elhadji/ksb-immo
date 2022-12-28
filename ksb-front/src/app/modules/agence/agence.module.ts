import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AgenceRoutingModule } from './agence-routing.module';
import { AllAgenceComponent } from './all-agence/all-agence.component';
import { CreateAgenceComponent } from './create-agence/create-agence.component';
import { UpdateAgenceComponent } from './update-agence/update-agence.component';
import { DetailsAgenceComponent } from './details-agence/details-agence.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';



import { FormatDatePipe } from 'src/app/shared/pipe/format-date.pipe';

import { NgxPaginationModule } from 'ngx-pagination';
@NgModule({
  declarations: [
    AllAgenceComponent,
    CreateAgenceComponent,
    UpdateAgenceComponent,
    DetailsAgenceComponent,
  ],
  imports: [
    CommonModule,
    AgenceRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    NgxPaginationModule

    // MatMomentDateModule,
  ],
  exports: [
    AllAgenceComponent,
    CreateAgenceComponent,
    UpdateAgenceComponent,
    DetailsAgenceComponent,
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AgenceModule { }
