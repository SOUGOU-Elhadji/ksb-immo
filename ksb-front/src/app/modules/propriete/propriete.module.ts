import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatTooltipModule } from '@angular/material/tooltip';
import { MatMenuModule } from '@angular/material/menu';
import { MatInputModule, MatTextareaAutosize } from '@angular/material/input';
import { MatDividerModule } from '@angular/material/divider';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatSelectModule } from '@angular/material/select';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
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
    DetailsProprieteComponent,
  ],
  imports: [
    CommonModule,
    ProprieteRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatSelectModule,
    MatExpansionModule,
    MatIconModule,
    MatButtonModule,
    MatToolbarModule,
    MatDividerModule,
    MatInputModule,
    MatMenuModule,
    MatTooltipModule,
    MatDatepickerModule,

  ],
  exports: [
    AllProprieteComponent,
    CreateProprieteComponent,
    UpdateProprieteComponent,
    DetailsProprieteComponent
  ]
})
export class ProprieteModule { }
