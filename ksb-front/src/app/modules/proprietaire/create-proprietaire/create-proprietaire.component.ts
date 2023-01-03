import { TypePropriete } from './../../../shared/enums/type-propriete';
import { ToastrService } from 'ngx-toastr';
import { ProprietaireService } from './../../../shared/services/proprietaire.service';
import { FormGroup, FormBuilder, FormArray } from '@angular/forms';
import { ProprieteDto } from './../../../shared/dts/propriete-dto';
import { ProprietaireDto } from './../../../shared/dts/proprietaire-dto';
import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ProprietaireDto } from 'src/app/shared/dts/proprietaire-dto';
import { ProprieteDto } from 'src/app/shared/dts/propriete-dto';
import { TypePropriete } from 'src/app/shared/enums/type-propriete';
import { ProprietaireService } from 'src/app/shared/services/proprietaire.service';

@Component({
  selector: 'app-create-proprietaire',
  templateUrl: './create-proprietaire.component.html',
  styleUrls: ['./create-proprietaire.component.css']
})
export class CreateProprietaireComponent implements OnInit {

  proprietaire !: ProprietaireDto;

  listProprietes : ProprieteDto[] = [];
  propriete !: ProprieteDto;

  typePropriete : typeof TypePropriete = TypePropriete;

  term !: string;

  added : boolean = false;

  public proprietaireForm !: FormGroup;

  constructor(private service : ProprietaireService,
            private toastr : ToastrService,

            private builder : FormBuilder,
            private router : Router) {

            }

  ngOnInit(): void {

    this.proprietaireForm = this.builder.group({
      nom : [''],
      prenom : [''],
      telephone : [''],
      email : [''],
      adresse : [''],
      profession : [''],
      dateNaissance : [''],
      cni : [''],
      dateDelivranceCni : [''],
      numCompteBancaire : [''],
      proprietes : new FormArray([])
    });
    this.propriete = new ProprieteDto();
  }

  public selectType(type : string){
    this.propriete.type = type;

  }

  public addPropriete(){
    this.listProprietes.push(this.propriete);
    this.added = true;
    this.propriete = new ProprieteDto();

  }

  public enregistrer(){
    this.proprietaire = this.proprietaireForm.value;
    this.proprietaire.proprietes = this.listProprietes;
    this.service.createProprietaire(this.proprietaire).subscribe(
      data => {
        if (data != null && data != undefined) {
          this.router.navigate(['/proprietaires']);
          this.showSuccess();
        } else {
          this.showError();
        }
      }
    );
  }

  public showSuccess() {
    this.toastr.success('Proprietaire enregistré avec succès', 'Success', {
      timeOut: 5000,
      progressBar: true,
      progressAnimation: 'increasing',
      positionClass: 'toast-bottom-right'
    });
  }

  public showError() {
    this.toastr.error('Erreur lors de l\'enregistrement du proprietaire', 'Error', {
      timeOut: 5000,
      progressBar: true,
      progressAnimation: 'increasing',
      positionClass: 'toast-bottom-right'
    });
  }
}