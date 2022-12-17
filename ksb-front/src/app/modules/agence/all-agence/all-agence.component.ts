import { Component, OnInit } from '@angular/core';
import { Agence } from 'src/app/shared/models/agence';
import { AgenceService } from 'src/app/shared/services/agence.service';

@Component({
  selector: 'app-all-agence',
  templateUrl: './all-agence.component.html',
  styleUrls: ['./all-agence.component.css']
})
export class AllAgenceComponent implements OnInit {

  agences!: Agence[];

  constructor(private serviceAgence: AgenceService) { }

  ngOnInit(): void {
    this.getAllAgence();
  }

  public getAllAgence(){
    return this.serviceAgence.getAllAgences().subscribe((response) => {
      try{
        this.agences = response;
        console.log(response);
      }catch (error){
        throw error;
      }
    })
  }

  public deleteAgence(agence : Agence){
    return this.serviceAgence.deleteAgence(agence.id).subscribe((response) => {
      try{
        this.getAllAgence();
      }catch (error){
        throw error;
      }
    })
  }

}
