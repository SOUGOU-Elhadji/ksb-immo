import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AgenceDto } from 'src/app/shared/dts/agence-dto';
import { Agence } from 'src/app/shared/models/agence';
import { Employee } from 'src/app/shared/models/employee';
import { AgenceService } from 'src/app/shared/services/agence.service';

@Component({
  selector: 'app-details-agence',
  templateUrl: './details-agence.component.html',
  styleUrls: ['./details-agence.component.css']
})
export class DetailsAgenceComponent implements OnInit {

  agence: AgenceDto = new AgenceDto();
  id!: string;

  constructor(private service: AgenceService,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.service.getAgenceById(this.id).subscribe(data => {
      this.agence = data;
    })
  }

}
