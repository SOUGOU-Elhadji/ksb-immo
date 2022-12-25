import { TypePropriete } from './../../../shared/enums/type-propriete';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ProprietaireService } from './../../../shared/services/proprietaire.service';
import { ProprietaireDto } from './../../../shared/dts/proprietaire-dto';
import { ProprieteDto } from './../../../shared/dts/propriete-dto';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-create-propriete',
  templateUrl: './create-propriete.component.html',
  styleUrls: ['./create-propriete.component.css']
})
export class CreateProprieteComponent implements OnInit {

  proprietaireId : string = this.activatedRoute.snapshot.params.id;

  propriete !: ProprieteDto;

  proprietaire !: ProprietaireDto;

  typePropriete = TypePropriete;
  list : string[] = [];

  form !: FormGroup;

  constructor(private route: Router, private activatedRoute: ActivatedRoute,
            private proprietaireService : ProprietaireService, private builder: FormBuilder) {
              //enregistrement des clés de l'enum dans un tableau en convertissant en string et en majuscule la première lettre
              this.list = Object.keys(this.typePropriete);
            }

  ngOnInit(): void {
    this.getProprietaire();

    //initialisation du formulaire
    this.form = this.builder.group({
      type: ['', [Validators.required]],
      adresse: ['', [Validators.required]],
      description: ['', [Validators.required]],
      prix: ['', [Validators.required]],
      surface: ['', [Validators.required]],
      nbreChambre: ['', [Validators.required]],
      nbreSalleDeBain: ['', [Validators.required]],
      nbreToilette: ['', [Validators.required]],
      nbreEtage: ['', [Validators.required]],
      nbreAppartementParEtage: ['', [Validators.required]],
      meuble: ['', [Validators.required]],
      garage: ['', [Validators.required]],
      jardin: ['', [Validators.required]],
      piscine: ['', [Validators.required]],
      ascenseur: ['', [Validators.required]],
      dateDisponibite: ['', [Validators.required]],
      apporteurAffaire: ['']
    });
  }

  public getProprietaire(){
    this.proprietaireService.getProprietaireById(this.proprietaireId).subscribe(
      (data: ProprietaireDto) => {
        this.proprietaire = data;
      }
    )
  }

}
