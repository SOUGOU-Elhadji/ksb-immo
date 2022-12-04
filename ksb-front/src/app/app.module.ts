import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { EmployeeModule } from './modules/employee/employee.module';
import { AgenceModule } from './modules/agence/agence.module';
import { LocataireModule } from './modules/locataire/locataire.module';
import { ProprietaireModule } from './modules/proprietaire/proprietaire.module';
import { ProprieteModule } from './modules/propriete/propriete.module';
import { UtilisateurModule } from './modules/utilisateur/utilisateur.module';
import { HomeComponent } from './home/home.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    EmployeeModule,
    AgenceModule,
    LocataireModule,
    ProprietaireModule,
    ProprieteModule,
    UtilisateurModule,
    AppRoutingModule,
    BrowserAnimationsModule
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
