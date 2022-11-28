import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProprietaireRoutingModule } from './proprietaire-routing.module';
import { DetailsProprietaireComponent } from './details-proprietaire/details-proprietaire.component';
import { UpdateProprietaireComponent } from './update-proprietaire/update-proprietaire.component';
import { CreateProprietaireComponent } from './create-proprietaire/create-proprietaire.component';
import { AllProprietaireComponent } from './all-proprietaire/all-proprietaire.component';


@NgModule({
  declarations: [
    DetailsProprietaireComponent,
    UpdateProprietaireComponent,
    CreateProprietaireComponent,
    AllProprietaireComponent
  ],
  imports: [
    CommonModule,
    ProprietaireRoutingModule
  ],
  exports: [
    DetailsProprietaireComponent,
    UpdateProprietaireComponent,
    CreateProprietaireComponent,
    AllProprietaireComponent
  ]
})
export class ProprietaireModule { }
