import { LocataireService } from 'src/app/shared/services/locataire.service';
import { Locataire } from 'src/app/shared/models/locataire';
import { LocataireDto } from './../../../shared/dts/locataire-dto';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-all-locataire',
  templateUrl: './all-locataire.component.html',
  styleUrls: ['./all-locataire.component.css']
})
export class AllLocataireComponent implements OnInit {


  p:number = 1;
  locataires : LocataireDto[] = [];
  term!: string;

  constructor(private service : LocataireService) { }

  ngOnInit(): void {
    this.fetchLocataire();
  }

  fetchLocataire() {
    this.service.getAllLocataire().subscribe(
      (data) => {
        this.locataires = data;
      },
      (error) => {
        console.log(error);
      }
    )
  }


  search(){}

  deleteLocataire(locataire: LocataireDto) {

  }

}
