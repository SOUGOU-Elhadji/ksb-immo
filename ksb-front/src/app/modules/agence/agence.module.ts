import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AgenceRoutingModule } from './agence-routing.module';
import { AllAgenceComponent } from './all-agence/all-agence.component';
import { CreateAgenceComponent } from './create-agence/create-agence.component';
import { UpdateAgenceComponent } from './update-agence/update-agence.component';
import { DetailsAgenceComponent } from './details-agence/details-agence.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

// material modules
import {MatIconModule} from '@angular/material/icon';
import {MatSelectModule} from '@angular/material/select';
import {MatButtonModule} from '@angular/material/button';
import {MatToolbarModule} from '@angular/material/toolbar'
import {MatDividerModule} from '@angular/material/divider';
import {MatInputModule} from '@angular/material/input';
import {MatMenuModule} from '@angular/material/menu';
import {MatTooltipModule} from '@angular/material/tooltip';
import {MatExpansionModule} from '@angular/material/expansion';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatTableModule} from '@angular/material/table';
import {MatRadioModule} from '@angular/material/radio';

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
    FormsModule,
    ReactiveFormsModule,

    MatExpansionModule,
    MatIconModule,
    MatSelectModule,
    MatButtonModule,
    MatToolbarModule,
    MatDividerModule,
    MatInputModule,
    MatMenuModule,
    MatTooltipModule,
    MatFormFieldModule,
    
    MatDatepickerModule,
    MatTableModule,
    MatRadioModule
  ],
  exports: [
    AllAgenceComponent,
    CreateAgenceComponent,
    UpdateAgenceComponent,
    DetailsAgenceComponent,

    MatExpansionModule,
    MatIconModule,
    MatSelectModule,
    MatButtonModule,
    MatToolbarModule,
    MatDividerModule,
    MatInputModule,
    MatMenuModule,
    MatTooltipModule,
    MatFormFieldModule,
    MatDatepickerModule,
    MatTableModule,
    MatRadioModule
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AgenceModule { }
