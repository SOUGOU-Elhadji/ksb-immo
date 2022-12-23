import { ProprietaireService } from './../../../shared/services/proprietaire.service';
import { ProprietaireDto } from './../../../shared/dts/proprietaire-dto';
import { Proprietaire } from './../../../shared/models/proprietaire';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-all-proprietaire',
  templateUrl: './all-proprietaire.component.html',
  styleUrls: ['./all-proprietaire.component.css']
})
export class AllProprietaireComponent implements OnInit {

  proprietaires !: Proprietaire[]
  p: number = 1;
  research !: string;

  constructor(private service : ProprietaireService) { }

  ngOnInit(): void {
    this.getProprietaires();
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

  // public search(){
  //   if (this.research != "") {
  //     // filter the proprietaires by all proprietaire's attributes
  //     this.proprietaires = this.proprietaires.filter(res => {
  //       return res.nom.toLocaleLowerCase().includes(this.research)
  //       || res.prenom.toLocaleLowerCase().includes(this.research)
  //       || res.adresse.toLocaleLowerCase().includes(this.research)
  //       || res.telephone.toLocaleLowerCase().includes(this.research)
  //       || res.email.toLocaleLowerCase().includes(this.research)
  //       || res.profession.toLocaleLowerCase().includes(this.research)
  //     })
  //   } else if (this.research == "") {
  //     this.ngOnInit();
  //   }
  // }
}
