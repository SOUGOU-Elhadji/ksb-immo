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

  agences!: Agence[];

  constructor(private serviceAgence: AgenceService,
              private router: Router) { }

  ngOnInit(): void {
    this.getAllAgence();
  }

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


  public deleteAgence(id: string) {
    return this.serviceAgence.deleteAgence(id).subscribe(data => {
      console.log(data);
      window.location.reload();
    })
  }


  updateAgence(id: string) {
    this.router.navigate(['agence/edit', id]);
  }




}
