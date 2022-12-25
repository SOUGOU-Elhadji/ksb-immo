import { TypePropriete } from './../../../shared/enums/type-propriete';
import { ProprieteService } from './../../../shared/services/propriete.service';
import { ProprieteDto } from './../../../shared/dts/propriete-dto';
import { ProprietaireService } from './../../../shared/services/proprietaire.service';
import { ProprietaireDto } from './../../../shared/dts/proprietaire-dto';
import { Proprietaire } from './../../../shared/models/proprietaire';
import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-all-proprietaire',
  templateUrl: './all-proprietaire.component.html',
  styleUrls: ['./all-proprietaire.component.css']
})
export class AllProprietaireComponent implements OnInit {

  proprietaires !: ProprietaireDto[]
  p: number = 1;
  research !: string;
  propriete !: ProprieteDto;
  form !: FormGroup;

  types = TypePropriete;

  typePropriete: string[] = []


  constructor(private service : ProprietaireService,
            private proprieteService : ProprieteService,
            private toastr: ToastrService,
            private builder: FormBuilder) {
              this.typePropriete = Object.keys(this.types);
            }

  ngOnInit(): void {
    this.getProprietaires();

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

  deleteProprietaire(id: string){
    console.log(id);
  }

  public getProprietaires(){
    this.service.getAllProprietaires().subscribe(
      data => {
        this.proprietaires = data;
      }
    )
  }

  public ajouterPropriete(){

  }


  showSuccessNotification() {
    this.toastr.success("Propriétaire ajouté avec succès", "Succès", {
      timeOut: 5000,
      progressBar: true,
      progressAnimation: 'decreasing',
      positionClass: 'toast-bottom-right'
    });
  }

  showErrorNotification() {
    this.toastr.error("Une erreur s'est produite", "Erreur", {
      timeOut: 5000,
      progressBar: true,
      progressAnimation: 'decreasing',
      positionClass: 'toast-bottom-right'
    });
  }

}
