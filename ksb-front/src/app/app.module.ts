import { LoyerNonPayesComponent } from './modules/loyer/loyer-non-payes/loyer-non-payes.component';
import { LoyerPayesComponent } from './modules/loyer/loyer-payes/loyer-payes.component';
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
import { MatMenuModule } from '@angular/material/menu';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { ToastrModule } from "ngx-toastr";

import { NgxPaginationModule } from 'ngx-pagination';
import { Ng2SearchPipeModule } from 'ng2-search-filter';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    AdminLayoutComponent,
    FooterComponent,
    ListApporteurComponent,
    NewApporteurComponent,
    LoyerPayesComponent,
    LoyerNonPayesComponent,
    
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
    MatMenuModule,
    MatSlideToggleModule,
    Ng2SearchPipeModule,

    NgxPaginationModule,
    ToastrModule.forRoot()
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
