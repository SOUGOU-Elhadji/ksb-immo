import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Agence } from 'src/app/shared/models/agence';
import { AgenceService } from 'src/app/shared/services/agence.service';

@Component({
  selector: 'app-all-agence',
  templateUrl: './all-agence.component.html',
  styleUrls: ['./all-agence.component.css']
})
export class AllAgenceComponent implements OnInit {

  p: number = 1;
  agences!: Agence[];
  departement!: string;



  constructor(private serviceAgence: AgenceService,
              private router: Router) { }

  ngOnInit(): void {
    this.getAllAgence();
  }

  // update(id: string){
  //   this.router.navigate(['agences', id, 'edit'])
  // }

  public getAllAgence() {
    return this.serviceAgence.getAllAgences().subscribe((response) => {
      try {
        this.agences = response;
        console.log(response);
      } catch (error) {
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

  public search(){
    if(this.departement != ""){
      this.agences = this.agences.filter(res =>{
        return res.departement.toLocaleLowerCase().match(this.departement.toLocaleLowerCase());
      });
    }else if(this.departement == ""){
      this.ngOnInit();
    }
    }

}
