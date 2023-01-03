import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ProprietaireDto } from 'src/app/shared/dts/proprietaire-dto';
import { ProprietaireService } from 'src/app/shared/services/proprietaire.service';

@Component({
  selector: 'app-update-proprietaire',
  templateUrl: './update-proprietaire.component.html',
  styleUrls: ['./update-proprietaire.component.css']
})
export class UpdateProprietaireComponent implements OnInit {

  public proprietaireForm !: FormGroup;

  proprietaire: ProprietaireDto = new ProprietaireDto();

  id !: string

  constructor(private service : ProprietaireService,
    private toastr : ToastrService,
    private builder : FormBuilder,
    private router : Router, private route : ActivatedRoute) {

    }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.service.getProprietaireById(this.id).subscribe(data =>{
      this.proprietaire = data;
    }, error => console.log(error));

    // this.getProprietaireById(this.id);

    console.log(this.id)

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
      numCompteBancaire : ['']
    });


  }

  updateProprietaire(){
    return this.service.updateProprietaire(this.proprietaire).subscribe(data =>{
      this.router.navigate(['/proprietaires'])
      console.log(data);
      this.showSuccess();
    }, (error) => {
      this.showError();
    });
  }

  // public getProprietaireById(id: string) {
  //   this.service.getProprietaireById(id).subscribe(
  //     (data) => {
  //       this.proprietaire = data;
  //       console.log(data)
  //     },
  //     (error) => {
  //       this.showError();
  //     }
  //   );
  // }

  private showSuccess() {
    this.toastr.success('Proprietaire modifié avec succès',
    'Modification du proprietaire',
    {
      timeOut: 5000,
      positionClass: 'toast-bottom-right',
      progressBar: true,
      progressAnimation: 'increasing',
    });
  }

  private showError() {
    this.toastr.error('Une erreur est survenue lors du traitement de votre demande',
    'Erreur',
    {
      timeOut: 5000,
      positionClass: 'toast-bottom-right',
      progressBar: true,
      progressAnimation: 'increasing',
    });
  }
}