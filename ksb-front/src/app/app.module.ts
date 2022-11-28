import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { EmployeeModule } from './modules/employee/employee.module';
import { AgenceModule } from './modules/agence/agence.module';
import { LocataireModule } from './modules/locataire/locataire.module';
import { ProprietaireModule } from './modules/proprietaire/proprietaire.module';
import { ProprieteModule } from './modules/propriete/propriete.module';
import { UtilisateurModule } from './modules/utilisateur/utilisateur.module';
import { HomeComponent } from './home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    EmployeeModule,
    AgenceModule,
    LocataireModule,
    ProprietaireModule,
    ProprieteModule,
    UtilisateurModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
