import { Component, OnInit } from '@angular/core';
import { Loyer } from 'src/app/shared/models/loyer';
import { LoyerService } from 'src/app/shared/services/loyer.service';

@Component({
  selector: 'app-loyer-payes',
  templateUrl: './loyer-payes.component.html',
  styleUrls: ['./loyer-payes.component.css']
})
export class LoyerPayesComponent implements OnInit {

  loyers: any[] = [];

  constructor(private service: LoyerService) { }

  ngOnInit(): void {
    this.service.getLoyers().subscribe(
      data => {
        this.loyers = data
        console.log(this.loyers);
      }
    )
  }

}
