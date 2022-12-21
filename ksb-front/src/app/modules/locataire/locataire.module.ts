import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LocataireRoutingModule } from './locataire-routing.module';
import { CreateLocataireComponent } from './create-locataire/create-locataire.component';
import { AllLocataireComponent } from './all-locataire/all-locataire.component';
import { UpdateLocataireComponent } from './update-locataire/update-locataire.component';
import { DetailsLocataireComponent } from './details-locataire/details-locataire.component';
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
@NgModule({
  declarations: [
    CreateLocataireComponent,
    AllLocataireComponent,
    UpdateLocataireComponent,
    DetailsLocataireComponent
  ],
  imports: [
    CommonModule,
    LocataireRoutingModule,
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
  ], 
  exports: [
    CreateLocataireComponent,
    AllLocataireComponent,
    UpdateLocataireComponent,
    DetailsLocataireComponent
  ]
})
export class LocataireModule { }
