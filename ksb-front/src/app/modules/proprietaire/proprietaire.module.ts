import { FormsModule } from '@angular/forms';
import { NgxPaginationModule } from 'ngx-pagination';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProprietaireRoutingModule } from './proprietaire-routing.module';
import { DetailsProprietaireComponent } from './details-proprietaire/details-proprietaire.component';
import { UpdateProprietaireComponent } from './update-proprietaire/update-proprietaire.component';
import { CreateProprietaireComponent } from './create-proprietaire/create-proprietaire.component';
import { AllProprietaireComponent } from './all-proprietaire/all-proprietaire.component';


import { Ng2SearchPipeModule } from 'ng2-search-filter';
@NgModule({
  declarations: [
    DetailsProprietaireComponent,
    UpdateProprietaireComponent,
    CreateProprietaireComponent,
    AllProprietaireComponent
  ],
  imports: [
    CommonModule,
    ProprietaireRoutingModule,
    NgxPaginationModule,
    Ng2SearchPipeModule,
    FormsModule
  ],
  exports: [
    DetailsProprietaireComponent,
    UpdateProprietaireComponent,
    CreateProprietaireComponent,
    AllProprietaireComponent
  ]
})
export class ProprietaireModule { }
