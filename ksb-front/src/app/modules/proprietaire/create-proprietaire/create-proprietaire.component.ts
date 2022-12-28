import { TypePropriete } from './../../../shared/enums/type-propriete';
import { ToastrService } from 'ngx-toastr';
import { ProprietaireService } from './../../../shared/services/proprietaire.service';
import { FormGroup, FormBuilder, FormArray } from '@angular/forms';
import { ProprieteDto } from './../../../shared/dts/propriete-dto';
import { ProprietaireDto } from './../../../shared/dts/proprietaire-dto';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-create-proprietaire',
  templateUrl: './create-proprietaire.component.html',
  styleUrls: ['./create-proprietaire.component.css']
})
export class CreateProprietaireComponent implements OnInit {

  proprietaire !: ProprietaireDto;
  listProprietes !: ProprieteDto[];
  propriete !: ProprieteDto;

  typePropriete = TypePropriete;
  list : string[] = [];

  term !: string;

  public proprietaireForm !: FormGroup;

  constructor(private service : ProprietaireService,
            private toastr : ToastrService,
            private builder : FormBuilder) {
              this.list = Object.keys(this.typePropriete);
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
      proprietes : new FormArray([
        this.builder.group({
          type : [''],
          description : [''],
          prix : [''],
          surface : [''],
          nbreChambre : [''],
          nbreSalleDeBain : [''],
          nbreToilette : [''],
          numeroLot : [''],
          nbreEtage : [''],
          nbreAppartementParEtage : [''],
          meuble : [''],
          garage : [''],
          jardin : [''],
          piscine : [''],
          ascenseur : [''],
          dateDisponibilite : [''],
          apporteurAffaire : new FormArray([])
        })
      ])
    });
  }

}
