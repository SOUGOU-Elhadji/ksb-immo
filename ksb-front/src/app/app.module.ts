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
import { HeaderComponent } from './header/header.component';
import { AdminLayoutComponent } from './admin-layout/admin-layout.component';
import { FooterComponent } from './footer/footer.component';
import { ListApporteurComponent } from './apporteur/list-apporteur/list-apporteur.component';
import { NewApporteurComponent } from './apporteur/new-apporteur/new-apporteur.component';
import {MatMenuModule} from '@angular/material/menu';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    AdminLayoutComponent,
    FooterComponent,
    ListApporteurComponent,
    NewApporteurComponent,
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
    BrowserAnimationsModule,
    MatMenuModule
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
