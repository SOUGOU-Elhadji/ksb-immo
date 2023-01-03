import { Component, OnInit } from '@angular/core';
import { AgenceDto } from '../shared/dts/agence-dto';
import { AgenceService } from '../shared/services/agence.service';
import { Agence } from '../shared/models/agence';
import { EmployeeDto } from '../shared/dts/employee-dto';
import { EmployeeService } from '../shared/services/employee.service';
import { Employee } from '../shared/models/employee';
import { Proprietaire } from '../shared/models/proprietaire';
import { ProprietaireService } from '../shared/services/proprietaire.service';
import { ProprietaireDto } from '../shared/dts/proprietaire-dto';
import { ProprieteDto } from '../shared/dts/propriete-dto';
import { ProprieteService } from '../shared/services/propriete.service';
import { LoyerService } from '../shared/services/loyer.service';
import { LoyerDto } from '../shared/dts/loyer-dto';
import { Loyer } from '../shared/models/loyer';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  agences: Agence[] = [];
  employers: Employee[] = [];
  proprietaires: ProprietaireDto[] = [];
  proprietes: ProprieteDto[] = [];
  loyers: Loyer[] = [];
  loyersImp: Loyer[] = [];

  constructor(
    private serviceAgence: AgenceService,
    private serviceEmployer: EmployeeService,
    private serviceProprietaire: ProprietaireService,
    private serviceProprietes: ProprieteService,
    private serviceLoyer: LoyerService,
  ) { }

  ngOnInit(): void {
    this.nombreAgence();
    this.nombreEmployer();
    this.nombreProprietaire();
    this.nombreLoyerPayer();
    this.nombreLoyerImpayer();
  }

  toggleMenu() {
  }

  nombreAgence(){
    this.serviceAgence.getAllAgences().subscribe((response) => {
      this.agences = response;
    })
  }

  nombreEmployer(){
    this.serviceEmployer.getAllEmployee().subscribe((response) => {
      this.employers = response;
    })
  }

  nombreProprietaire(){
    this.serviceProprietaire.getAllProprietaires().subscribe((response) => {
      this.proprietaires = response;
    })
  }

  nombreProprietes(){
    // this.serviceProprietes.
  }

  nombreLoyerPayer(){
    this.serviceLoyer.getLoyers().subscribe((response) => {
      this.loyers = response;
    })
  }

  nombreLoyerImpayer(){
    this.serviceLoyer.getLoyersNonPayes().subscribe((response) => {
      this.loyersImp = response;
    })
  }

}
