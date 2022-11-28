import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UtilisateurRoutingModule } from './utilisateur-routing.module';
import { DetailsUtilisateurComponent } from './details-utilisateur/details-utilisateur.component';
import { UpdateUtilisateurComponent } from './update-utilisateur/update-utilisateur.component';
import { CreateUtilisateurComponent } from './create-utilisateur/create-utilisateur.component';
import { AllUtilisateurComponent } from './all-utilisateur/all-utilisateur.component';


@NgModule({
  declarations: [
    DetailsUtilisateurComponent,
    UpdateUtilisateurComponent,
    CreateUtilisateurComponent,
    AllUtilisateurComponent
  ],
  imports: [
    CommonModule,
    UtilisateurRoutingModule
  ],
  exports: [
    DetailsUtilisateurComponent,
    UpdateUtilisateurComponent,
    CreateUtilisateurComponent,
    AllUtilisateurComponent
  ]
})
export class UtilisateurModule { }
