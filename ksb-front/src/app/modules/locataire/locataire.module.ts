import { NgxMaskModule } from 'ngx-mask';
import { NgxPaginationModule } from 'ngx-pagination';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LocataireRoutingModule } from './locataire-routing.module';
import { CreateLocataireComponent } from './create-locataire/create-locataire.component';
import { AllLocataireComponent } from './all-locataire/all-locataire.component';
import { UpdateLocataireComponent } from './update-locataire/update-locataire.component';
import { DetailsLocataireComponent } from './details-locataire/details-locataire.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

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
    NgxPaginationModule,
    NgxMaskModule.forRoot(),
  ],
  exports: [
    CreateLocataireComponent,
    AllLocataireComponent,
    UpdateLocataireComponent,
    DetailsLocataireComponent
  ]
})
export class LocataireModule { }
